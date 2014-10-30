package com.xinfan.msgbox.service.messagecache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.Position;

public abstract class MessageCacheSupport extends Thread implements MessageCacheCenter{
	private Map<Long,CachedMessage> msgCache = new ConcurrentHashMap<Long,CachedMessage>();
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
	
	private List<MessageChangeListener> listeners = new LinkedList<MessageChangeListener>();
	private int currentListenerIndex=0;
	
	
	public void addMessageChangeListener(MessageChangeListener e)
	{
		this.listeners.add(e);
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
//		List<Long> msgIds = areaMsgCache.get(areaName);
		List<Long> msgIds = new LinkedList<Long>();
		msgIds.add(Long.parseLong("1"));
		if(null == msgIds || msgIds.isEmpty()) return Collections.EMPTY_LIST;
		 
		//先返回所有看看运行效果  cyp
		CachedMessage[] values = (CachedMessage[]) msgCache.values().toArray(new CachedMessage[msgCache.values().size()]);
		return Arrays.asList(values);
		//return getMessageByIds(msgIds);
	}

	public boolean addMessageDirectlly(List<CachedMessage> msgs)
	{
		for(CachedMessage msg:msgs)
		{
			msgCache.put(msg.getMessageId(), msg);
			//userMsgCache.put(msg.getUserId(), msg.getMessageId());
		}
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
	
	@Override
	public List<CachedMessage> getMessageByIds(List<Long> msgIds) {
		List<CachedMessage> messages = new ArrayList<CachedMessage>(msgIds.size());
		for(Long id:msgIds)
		{
			messages.add(msgCache.get(id));
		}
		return messages;
	}
	
	@Override
	public CachedMessage getMessageById(Long msgId) {
			return msgCache.get(msgId);
	}
	
	
	@Override
	public List<CachedMessage> getAllMessages() {
		List<CachedMessage> list = new LinkedList<CachedMessage>();
		for(Entry<Long, CachedMessage> entry:msgCache.entrySet())
		{
			list.add(entry.getValue());
		}
		return list;
	}
	
	/**
	 * 自我刷新，将addQueue updateQueue deleteQueue队列中的改变同步到msgCache中
	 * 刷新时，让改变写入零时的队列TOD
	 * 	 
	 */
	protected void selfRefresh()
	{
		CachedMessage message;
		List<Long> changes = new LinkedList<Long>();
		while((message = addQueue.poll()) != null)
		{
			msgCache.put(message.getMessageId(), message);
			//userMsgCache.get(message.getUserId()).add(message.getMessageId());
			//TODO area怎么算
			changes.add(message.getMessageId());
		}
		
		while((message = updateQueue.poll()) != null)
		{
			msgCache.put(message.getMessageId(), message);
			//userMsgCache.get(message.getUserId()).add(message.getMessageId());
			//TODO area怎么算
			changes.add(message.getMessageId());
		}
		
		if(!changes.isEmpty() && !listeners.isEmpty())
		{
			listeners.get(currentListenerIndex++).onMessageAdded(changes);
			if(currentListenerIndex>listeners.size()-1) currentListenerIndex = 0;
		}
	}
	@Override
	public void run() {
		for(;;)
		{
			try {
				selfRefresh();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
