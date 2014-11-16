package com.xinfan.msgbox.core.processor;

import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.core.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.core.listener.MessageChangeListener;
import com.xinfan.msgbox.core.listener.MessageMatchedListener;
import com.xinfan.msgbox.core.messagecache.MessageCache;
import com.xinfan.msgbox.core.vo.CachedMessage;

public abstract class MessageProcessor extends Thread implements MessageChangeListener{
	private MessageCache localPool;
	private MessageCache listenPool;

	private MessageMatchedListener listener;
	private SimilarityAlgorithm algorithm;

	private LinkedBlockingQueue<CachedMessage> changedMessages = new LinkedBlockingQueue<CachedMessage>();

	public MessageProcessor(MessageCache local, MessageCache listen, MessageMatchedListener listener, SimilarityAlgorithm algorithm) {
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

	public MessageCache getLocalPool() {
		return localPool;
	}

	public void setLocalPool(MessageCache localPool) {
		this.localPool = localPool;
	}

	public MessageCache getListenPool() {
		return listenPool;
	}

	public void setListenPool(MessageCache listenPool) {
		this.listenPool = listenPool;
	}

	@Override
	public void run() {
		for (;;) {
			try {
					CachedMessage changes = changedMessages.poll();
					if (null != changes) {
	//					List<CachedMessage> changedMsgs = this.listenPool.getMessageByIds(changes);
						matchChanges(changes);
					} else {
						try {
							Thread.sleep(10);
						} catch (Exception e) {
	
						}
					}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	protected abstract void matchChanges(CachedMessage m);

	@Override
	public void onMessageAdded(CachedMessage m) {
		while (!changedMessages.offer(m))
			;
	}

	@Override
	public void onMessageUpdated(CachedMessage o,CachedMessage m) {
		while (!changedMessages.offer(m))
			;
	}

	@Override
	public void onMessageDeleted(CachedMessage m) {
		// nothing to do
	}
}
