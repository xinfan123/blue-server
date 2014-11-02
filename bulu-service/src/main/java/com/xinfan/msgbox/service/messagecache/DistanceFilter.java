package com.xinfan.msgbox.service.messagecache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.http.service.BizConstants;
import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;
import com.xinfan.msgbox.vo.Position;

public class DistanceFilter extends AbstractMessageFilter{

	/**
	 * 每个消息所在的位置
	 */
	private Map<Long, Position> posMap = new HashMap<Long, Position>();
	
	public DistanceFilter(MessageCache m) {
		super(m);
	}
		@Override
	public boolean addMessage(CachedMessage msg) {
		posMap.put(msg.getMessageId(), msg.getSrcPosition());
		return successor.addMessage(msg);
	}

	@Override
	public boolean updateMessage(CachedMessage old,CachedMessage msg) {
		Position oldp = old.getSrcPosition();
		Position newp = msg.getSrcPosition();
		if(!oldp.getGpsx().equals(newp.getGpsx()) || !oldp.getGpsy().equals(newp.getGpsy()))
		{
			posMap.put(msg.getMessageId(), msg.getSrcPosition());
		}
		return successor.updateMessage(old,msg);
	}
	
	@Override
	public boolean deleteMessage(CachedMessage msg) {
		posMap.remove(msg.getMessageId());
		return successor.deleteMessage(msg);
	}

	@Override
	public List<CachedMessage> queryMessage(MessageQueryInfo queryInfo) {
		CachedMessage current = queryInfo.getCurrent();
		if(null == current) return Collections.EMPTY_LIST;
		
		if(current.getMatchType() == BizConstants.MESSAGE_MATCH_BY_DISTANCE){
			List<Long> ids = queryInfo.getCandidates();
			if(ids != null && !ids.isEmpty())
			{
				for(Iterator<Long> it=ids.iterator();it.hasNext();)
				{
					   Long id = it.next();
					   Position p = posMap.get(id);
						if(null != p && p.calcDistance(current.getSrcPosition()) > current.getDistance())
						{
							it.remove();
						}
					   
				}
			}
			queryInfo.setCandidates(ids);
		}
		return super.queryMessage(queryInfo);
//		
//		if(successor instanceof MessageQuery)
//		{
//			return ((MessageQuery) successor).queryMessage(queryInfo);
//		}else
//		{
//			return successor.getMessageByIds(queryInfo.getCandidates());
//		}		
	}
}
