package com.xinfan.msgbox.service.messagecache;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;
import com.xinfan.msgbox.vo.Position;

public class AreaFilter extends AbstractMessageFilter{
	
	/**
	 * 每个区域有哪些消息
	 */
	private Map<String,List<Long>> areaMsgs = new HashMap<String, List<Long>>();
	
	public AreaFilter(MessageCache m) {
		super(m);
	}


	@Override
	public boolean addMessage(CachedMessage msg) {
		Position p = msg.getSrcPosition();
		List<Long> ids = areaMsgs.get(p.getAreaName());
		if(null == ids) ids=new LinkedList<Long>();
		ids.add(msg.getMessageId());
		areaMsgs.put(p.getAreaName(), ids);
		return successor.addMessage(msg);
	}

	@Override
	public boolean updateMessage(CachedMessage old, CachedMessage msg) {
		String oldArea = old.getSrcPosition().getAreaName();
		String newArea = msg.getSrcPosition().getAreaName();
		if(!oldArea.equals(newArea))
		{
			List<Long> oldIds = areaMsgs.get(oldArea);
			if(null == oldIds) oldIds = new LinkedList<Long>();
			oldIds.remove(old.getMessageId());
			areaMsgs.put(oldArea, oldIds);
			
			List<Long> newIds = areaMsgs.get(newArea);
			if(null == newIds) newIds = new LinkedList<Long>();
			newIds.add(msg.getMessageId());
			areaMsgs.put(newArea, newIds);
		}
		
		return successor.updateMessage(old, msg);
	}
	
	@Override
	public boolean deleteMessage(CachedMessage msg) {
		Position p = msg.getSrcPosition();
		List<Long> ids = areaMsgs.get(p.getAreaName());
		if(null != ids)
		{
			ids.remove(msg.getMessageId());
		}
		areaMsgs.put(p.getAreaName(), ids);
		return successor.deleteMessage(msg);
	}

	@Override
	public List<CachedMessage> queryMessage(MessageQueryInfo queryInfo) {
		CachedMessage current = queryInfo.getCurrent();
		if(null == current) return Collections.EMPTY_LIST;
		
		List<Long> ids = areaMsgs.get(current.getSrcPosition().getAreaName());
		queryInfo.setCandidates(ids);
		
		return super.queryMessage(queryInfo);
	}
}
