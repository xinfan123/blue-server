package com.xinfan.msgbox.core.messagecache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.core.listener.MessageChangeListener;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;

/**
 * 内存消息缓存实现
 * @author wendell
 *
 */
public class MemoryMessageCache implements MessageCache{
	private Map<Long,CachedMessage> msgCache = new ConcurrentHashMap<Long,CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> addQueue = new LinkedBlockingQueue<CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> updateQueue = new LinkedBlockingQueue<CachedMessage>();
	private LinkedBlockingQueue<CachedMessage> deleteQueue = new LinkedBlockingQueue<CachedMessage>();

	private List<Long> allMsgIds = new LinkedList<Long>();
	
	private MessageFilterChain filterChain = new MessageFilterChain();
	
	//	/**
//	 * 用户所有的消息key
//	 */
//	private Map<Long,List<Long>> userMsgCache = new HashMap<Long, List<Long>>();
//	
//	/**
//	 * area所有的消息key
//	 */
//	private Map<String,List<Long>> areaMsgCache = new HashMap<String, List<Long>>();
	
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

//	@Override
//	public List<CachedMessage> getUserMessage(long userId) {
//		List<Long> msgIds = userMsgCache.get(userId);
//		if(null == msgIds || msgIds.isEmpty()) return Collections.EMPTY_LIST;
//		
//		return getMessageByIds(msgIds);
//	}

//	@Override
//	public List<CachedMessage> getMessageByDistance(Position position,
//			int meters) {
//		//先算出position所在的地区
//		
//		//滤掉一部分消息 再做后续计算
//		
//		//默认取长沙的
//		return getMessageByArea("长沙");
//	}

//	@Override
//	public List<CachedMessage> getMessageByArea(String areaName) {
////		List<Long> msgIds = areaMsgCache.get(areaName);
//		List<Long> msgIds = new LinkedList<Long>();
//		msgIds.add(Long.parseLong("1"));
//		if(null == msgIds || msgIds.isEmpty()) return Collections.EMPTY_LIST;
//		 
//		//先返回所有看看运行效果  cyp
//		CachedMessage[] values = (CachedMessage[]) msgCache.values().toArray(new CachedMessage[msgCache.values().size()]);
//		return Arrays.asList(values);
//		//return getMessageByIds(msgIds);
//	}

	public boolean addMessageDirectlly(List<CachedMessage> msgs)
	{
		for(CachedMessage msg:msgs)
		{
			msgCache.put(msg.getMessageId(), msg);
			//userMsgCache.put(msg.getUserId(), msg.getMessageId());
			allMsgIds.add(msg.getMessageId());
			
			filterChain.onMessageAdded(msg);
		}
		return true;
	}
	
	@Override
	public boolean addMessage(CachedMessage msg) {
//		return addQueue.offer(msg);
		msgCache.put(msg.getMessageId(), msg);
		allMsgIds.add(msg.getMessageId());
		filterChain.onMessageAdded(msg);
		if(!listeners.isEmpty())
		{
			listeners.get(currentListenerIndex++).onMessageAdded(msg);
			if(currentListenerIndex>listeners.size()-1) currentListenerIndex = 0;
		}
		return true;
	}

	@Override
	public boolean updateMessage(CachedMessage old,CachedMessage msg) {
//		return updateQueue.offer(msg);
		msgCache.put(msg.getMessageId(), msg);
		filterChain.onMessageUpdated(old, msg);
		if(!listeners.isEmpty())
		{
			listeners.get(currentListenerIndex++).onMessageUpdated(old,msg);
			if(currentListenerIndex>listeners.size()-1) currentListenerIndex = 0;
		}
		return true;
	}

	@Override
	public boolean deleteMessage(CachedMessage msg) {
//		return deleteQueue.offer(msg);
		msgCache.remove(msg.getMessageId());
		allMsgIds.remove(msg.getMessageId());
		filterChain.onMessageDeleted(msg);
		if(!listeners.isEmpty())
		{
			listeners.get(currentListenerIndex++).onMessageDeleted(msg);
			if(currentListenerIndex>listeners.size()-1) currentListenerIndex = 0;
		}
		return true;
	}
	
	@Override
	public List<CachedMessage> getMessageByIds(List<Long> msgIds) {
		if(CollectionUtils.isEmpty(msgIds)) return Collections.EMPTY_LIST;
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

	@Override
	public List<Long> getAllMessageIds() {
		if(CollectionUtils.isEmpty(allMsgIds)) return Collections.EMPTY_LIST;
		List<Long> copy = new ArrayList<Long>(allMsgIds.size());
		Collections.copy(allMsgIds, copy);
		return copy;
	}

	@Override
	public void addMessageFilter(MessageQuery query) {
		filterChain.addFilter(query);
	}

	@Override
	public List<CachedMessage> queryMessage(MessageQueryInfo query) {
		filterChain.doQuery(query);
		
		List<Long> ids  = null;
		if(CollectionUtils.isEmpty(query.getCandidates()))
		{
			ids = getAllMessageIds();
		}else
		{
			ids = query.getCandidates();
		}
		if(!CollectionUtils.isEmpty(query.getExcludes()))
		{
			ids.removeAll(query.getExcludes());
		}
		return getMessageByIds(ids);
	}

//	@Override
//	public boolean updateMessagePosition(CachedMessage msg) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean updateMessageValideTime(CachedMessage msg) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
//	/**
//	 * 自我刷新，将addQueue updateQueue deleteQueue队列中的改变同步到msgCache中
//	 * 刷新时，让改变写入零时的队列TOD
//	 * 	 
//	 */
//	protected void selfRefresh()
//	{
//		CachedMessage message;
//		List<Long> changes = new LinkedList<Long>();
//		while((message = addQueue.poll()) != null)
//		{
//			msgCache.put(message.getMessageId(), message);
//			//userMsgCache.get(message.getUserId()).add(message.getMessageId());
//			//TODO area怎么算
//			changes.add(message.getMessageId());
//		}
//		
//		while((message = updateQueue.poll()) != null)
//		{
//			msgCache.put(message.getMessageId(), message);
//			//userMsgCache.get(message.getUserId()).add(message.getMessageId());
//			//TODO area怎么算
//			changes.add(message.getMessageId());
//		}
//		
//		if(!changes.isEmpty() && !listeners.isEmpty())
//		{
//			listeners.get(currentListenerIndex++).onMessageAdded(changes);
//			if(currentListenerIndex>listeners.size()-1) currentListenerIndex = 0;
//		}
//	}
//	public void run() {
//		for(;;)
//		{
//			try {
//				selfRefresh();
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
