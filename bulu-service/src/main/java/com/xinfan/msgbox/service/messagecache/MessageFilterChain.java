package com.xinfan.msgbox.service.messagecache;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public class MessageFilterChain  implements MessageQuery{

	List<MessageQuery> queryFilters = new LinkedList<MessageQuery>();
	
	public MessageFilterChain addFilter(MessageQuery query)
	{
		queryFilters.add(query);
		return this;
	}

	@Override
	public void doQuery(MessageQueryInfo queryInfo) {
		for(MessageQuery query:queryFilters)
		{
			query.doQuery(queryInfo);
		}
	}

	@Override
	public void onMessageAdded(CachedMessage msg) {
		for(MessageQuery query:queryFilters)
		{
			query.onMessageAdded(msg);
		}		
	}

	@Override
	public void onMessageUpdated(CachedMessage old,CachedMessage msg) {
		for(MessageQuery query:queryFilters)
		{
			query.onMessageUpdated(old,msg);
		}		
	}

	@Override
	public void onMessageDeleted(CachedMessage msg) {
		for(MessageQuery query:queryFilters)
		{
			query.onMessageDeleted(msg);
		}		
	}
	

}
