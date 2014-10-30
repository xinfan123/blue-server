package com.xinfan.msgbox.service.processor;

import java.util.List;
import java.util.Map.Entry;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.MessageCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;

public class InterestsMessageProcessor extends MessageProcessor{

	
	public InterestsMessageProcessor(MessageCacheCenter local,
			MessageCacheCenter listen, MessageMatchedListener listener,
			SimilarityAlgorithm algorithm) {
		super(local, listen, listener, algorithm);
	}

	@Override
	protected void matchChanges(List<CachedMessage> changedMsgs) {
		for(CachedMessage msg:changedMsgs)
		{
//			for(Entry<Long, CachedMessage> entry:local)
			for(CachedMessage interests:this.getLocalPool().getAllMessages())
			{
				if(this.getAlgorithm().matched(interests, msg))
				{
					getListener().onMessageMatched(interests, msg);
				}
			}
			
		}
	}
	
}
