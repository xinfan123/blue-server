package com.xinfan.msgbox.service.processor;

import java.util.List;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.MessageCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;

public class SentMessageProcessor extends MessageProcessor{

	public SentMessageProcessor(MessageCacheCenter local,
			MessageCacheCenter listen, MessageMatchedListener listener,
			SimilarityAlgorithm algorithm) {
		super(local, listen, listener, algorithm);
	}

	@Override
	protected void matchChanges(List<CachedMessage> changedMsgs) {
		for(CachedMessage interest:changedMsgs)
		{
			for(CachedMessage msg:this.getLocalPool().getAllMessages())
			{
				if(this.getAlgorithm().matched(interest, msg))
				{
					getListener().onMessageMatched(interest, msg);
				}
			}
		}
	}

}
