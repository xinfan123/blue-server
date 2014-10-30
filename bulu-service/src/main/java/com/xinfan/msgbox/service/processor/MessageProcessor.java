package com.xinfan.msgbox.service.processor;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.MessageCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;

public abstract class MessageProcessor extends Thread implements MessageChangeListener{
	private MessageCacheCenter localPool;
	private MessageCacheCenter listenPool;

	private MessageMatchedListener listener;
	private SimilarityAlgorithm algorithm;

	private LinkedBlockingQueue<List<Long>> changedMessages = new LinkedBlockingQueue<List<Long>>();

	public MessageProcessor(MessageCacheCenter local, MessageCacheCenter listen, MessageMatchedListener listener, SimilarityAlgorithm algorithm) {
		this.localPool = local;
		this.listenPool = listen;
		this.listenPool.addMessageChangeListener(this);
		this.listener = listener;
		this.algorithm = algorithm;
	}

	public MessageMatchedListener getListener() {
		return listener;
	}

	public void setListener(MessageMatchedListener listener) {
		this.listener = listener;
	}

	public SimilarityAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(SimilarityAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public MessageCacheCenter getLocalPool() {
		return localPool;
	}
	public void setLocalPool(MessageCacheCenter localPool) {
		this.localPool = localPool;
	}

	public MessageCacheCenter getListenPool() {
		return listenPool;
	}

	public void setListenPool(MessageCacheCenter listenPool) {
		this.listenPool = listenPool;
	}

	@Override
	public void run() {
		try {
			for (;;) {
				List<Long> changes = changedMessages.poll();
				if (null != changes && !changes.isEmpty()) {
					List<CachedMessage> changedMsgs = this.listenPool.getMessageByIds(changes);
					matchChanges(changedMsgs);
				} else {
					try {
						Thread.sleep(10);
					} catch (Exception e) {

					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	protected abstract void matchChanges(List<CachedMessage> changedMsgs);

	@Override
	public void onMessageAdded(List<Long> msgIds) {
		while (!changedMessages.offer(msgIds))
			;
	}

	@Override
	public void onMessageUpdated(List<Long> msgIds) {
		while (!changedMessages.offer(msgIds))
			;
	}

	@Override
	public void onMessageDeleted(List<Long> msgIds) {
		// nothing to do
	}
}
