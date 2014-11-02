package com.xinfan.msgbox.service.processor;

import java.util.concurrent.LinkedBlockingQueue;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.AbstractMessageFilter;
import com.xinfan.msgbox.service.messagecache.MessageCache;
import com.xinfan.msgbox.vo.CachedMessage;

public abstract class MessageProcessor extends Thread implements MessageChangeListener{
	private AbstractMessageFilter localPool;
	private AbstractMessageFilter listenPool;

	private MessageMatchedListener listener;
	private SimilarityAlgorithm algorithm;

	private LinkedBlockingQueue<CachedMessage> changedMessages = new LinkedBlockingQueue<CachedMessage>();

	public MessageProcessor(AbstractMessageFilter local, AbstractMessageFilter listen, MessageMatchedListener listener, SimilarityAlgorithm algorithm) {
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

	public AbstractMessageFilter getLocalPool() {
		return localPool;
	}

	public void setLocalPool(AbstractMessageFilter localPool) {
		this.localPool = localPool;
	}

	public AbstractMessageFilter getListenPool() {
		return listenPool;
	}

	public void setListenPool(AbstractMessageFilter listenPool) {
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
	public void onMessageUpdated(CachedMessage m) {
		while (!changedMessages.offer(m))
			;
	}

	@Override
	public void onMessageDeleted(CachedMessage m) {
		// nothing to do
	}
}
