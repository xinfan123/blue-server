package com.xinfan.msgbox.service.messagecache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.Position;

public abstract class MessageCacheSupport implements MessageCacheCenter{
	private Map<Long,CachedMessage> msgCache = new HashMap<Long,CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> addQueue = new LinkedBlockingQueue<CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> updateQueue = new LinkedBlockingQueue<CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> deleteQueue = new LinkedBlockingQueue<CachedMessage>();
	/**
	 * 用户所有的消息key
	 */
	private Map<Long,List<Long>> userMsgCache = new HashMap<Long, List<Long>>();
	
	/**
	 * area所有的消息key
	 */
	private Map<String,List<Long>> areaMsgCache = new HashMap<String, List<Long>>();
	
	private MessageChangeListener listener;
	
	public MessageChangeListener getListener() {
		return listener;
	}

	public void setListeners(MessageChangeListener listener) {
		this.listener = listener;
	}


	@Override
	public int getMessageCount() {
		// TODO Auto-generated method stub
		return msgCache.size();
	}

	@Override
	public List<CachedMessage> getUserMessage(long userId) {
		List<Long> msgIds = userMsgCache.get(userId);
		if(null == msgIds || msgIds.isEmpty()) return Collections.EMPTY_LIST;
		
		return getMessageByIds(msgIds);
	}

	@Override
	public List<CachedMessage> getMessageByDistance(Position position,
			int meters) {
		//先算出position所在的地区
		
		//滤掉一部分消息 再做后续计算
		
		//默认取长沙的
		return getMessageByArea("长沙");
	}

	@Override
	public List<CachedMessage> getMessageByArea(String areaName) {
		List<Long> msgIds = areaMsgCache.get(areaName);
		if(null == msgIds || msgIds.isEmpty()) return Collections.EMPTY_LIST;
		
		return getMessageByIds(msgIds);
	}

	public boolean addMessageDirectlly(List<CachedMessage> msgs)
	{
		return true;
	}
	
	@Override
	public boolean addMessage(CachedMessage msg) {
		return addQueue.offer(msg);
	}

	@Override
	public boolean updateMessage(CachedMessage msg) {
		return updateQueue.offer(msg);
	}

	@Override
	public boolean deleteMessage(CachedMessage msg) {
		return deleteQueue.offer(msg);
	}
	
	public List<CachedMessage> getMessageByIds(List<Long> msgIds) {
		List<CachedMessage> messages = new ArrayList<CachedMessage>(msgIds.size());
		for(Long id:msgIds)
		{
			messages.add(msgCache.get(id));
		}
		return messages;
	}
	
	/**
	 * 自我刷新，将addQueue updateQueue deleteQueue队列中的改变同步到msgCache中
	 * 刷新时，让改变写入零时的队列TOD
	 * 	 
	 */
	private void selfRefresh()
	{
		CachedMessage message;
		List<Long> changes = new LinkedList<Long>();
		while((message = addQueue.poll()) != null)
		{
			msgCache.put(message.getMessageId(), message);
			userMsgCache.get(message.getUserId()).add(message.getMessageId());
			//TODO area怎么算
			changes.add(message.getMessageId());
		}
		if(null != listener)
		{
			listener.onMessageAdded(changes);
		}
		//
	}

}
