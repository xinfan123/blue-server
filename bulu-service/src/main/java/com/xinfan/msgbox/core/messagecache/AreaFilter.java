package com.xinfan.msgbox.core.messagecache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;
import com.xinfan.msgbox.core.vo.Position;

public class AreaFilter implements MessageQuery{
	
	/**
	 * 每个区域有哪些消息
	 */
	private Map<String,List<Long>> areaMsgs = new HashMap<String, List<Long>>();

	@Override
	public void onMessageAdded(CachedMessage msg) {
		Position p = msg.getSrcPosition();
		List<Long> ids = areaMsgs.get(p.getAreaName());
		if(null == ids) ids=new LinkedList<Long>();
		ids.add(msg.getMessageId());
		areaMsgs.put(p.getAreaName(), ids);
		
	}


	@Override
	public void onMessageUpdated(CachedMessage old,CachedMessage msg) {
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
				
	}


	@Override
	public void onMessageDeleted(CachedMessage msg) {
		Position p = msg.getSrcPosition();
		List<Long> ids = areaMsgs.get(p.getAreaName());
		if(null != ids)
		{
			ids.remove(msg.getMessageId());
		}
		areaMsgs.put(p.getAreaName(), ids);
		
	}


	@Override
	public void doQuery(MessageQueryInfo queryInfo) {
		CachedMessage current = queryInfo.getCurrent();
		
		List<Long> ids = areaMsgs.get(current.getSrcPosition().getAreaName());
		if(CollectionUtils.isEmpty(ids)) return;
		if(!CollectionUtils.isEmpty(queryInfo.getCandidates()))
		{
			queryInfo.setCandidates(ids);
		}else
		{
			queryInfo.getCandidates().addAll(ids);
		}
	}
}
