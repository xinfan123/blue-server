package com.xinfan.msgbox.core.messagecache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.http.service.BizConstants;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;
import com.xinfan.msgbox.vo.Position;

public class DistanceFilter implements MessageQuery{

	/**
	 * 每个消息所在的位置
	 */
	private Map<Long, Position> posMap = new HashMap<Long, Position>();

	@Override
	public void onMessageAdded(CachedMessage msg) {
		posMap.put(msg.getMessageId(), msg.getSrcPosition());		
	}
	@Override
	public void onMessageUpdated(CachedMessage old,CachedMessage msg) {
		if(!old.getSrcPosition().equals(msg.getSrcPosition()))
		{
			posMap.put(msg.getMessageId(), msg.getSrcPosition());
		}
	}
	@Override
	public void onMessageDeleted(CachedMessage msg) {
		posMap.remove(msg.getMessageId());		
	}
	@Override
	public void doQuery(MessageQueryInfo queryInfo) {
		CachedMessage current = queryInfo.getCurrent();
		
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
	}
}
