package com.xinfan.msgbox.service.processor;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.MessageCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;

public class MessageProcessor extends Thread implements MessageChangeListener{
	private MessageCacheCenter interestsMessageCache;
	private MessageCacheCenter messageCachePool;
	private MessageMatchedListener listener;
	private SimilarityAlgorithm algorithm;
	
	private LinkedBlockingQueue<List<Long>> changedMessages = new LinkedBlockingQueue<List<Long>>();
	
	public MessageProcessor(MessageCacheCenter local,MessageCacheCenter listen,MessageMatchedListener listener,SimilarityAlgorithm algorithm) {
		this.interestsMessageCache = local;
		this.messageCachePool = listen;
		this.messageCachePool.setMessageChangeListener(this);
		this.listener = listener;
		this.algorithm = algorithm;
	}
	
	@Override
	public void run() {
		try
		{
			for(;;)
			{
				List<Long> changes = changedMessages.poll();
				if(null != changes && !changes.isEmpty())
				{
					matchChanges(changes);
				}else
				{
					try{
						Thread.sleep(10);
					}
					catch(Exception e)
					{
						
					}
				}
			}
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

	
	private void matchChanges(List<Long> changes) {
		List<CachedMessage> messages = messageCachePool.getMessageByIds(changes);
		for(CachedMessage message: messages)
		{
			//TODO filter模式过滤不合法的消息
			List<CachedMessage> firstMatch = interestsMessageCache.getMessageByDistance(message.getTargetPosition(), 1000);
			for(CachedMessage interest:firstMatch)
			{
				if(algorithm.matched(interest, message))
				{
					listener.onMessageMatched(interest, message);
				}
			}
		}
	}

	@Override
	public void onMessageAdded(List<Long> msgIds) {
		while(!changedMessages.offer(msgIds));
	}

	@Override
	public void onMessageUpdated(List<Long> msgIds) {
		while(!changedMessages.offer(msgIds));		
	}

	@Override
	public void onMessageDeleted(List<Long> msgIds) {
		//nothing to do
	}
}
