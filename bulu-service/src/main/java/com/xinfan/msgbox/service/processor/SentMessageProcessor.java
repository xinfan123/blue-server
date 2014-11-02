package com.xinfan.msgbox.service.processor;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.service.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.AbstractMessageFilter;
import com.xinfan.msgbox.service.messagecache.MessageCache;
import com.xinfan.msgbox.service.messagecache.MessageQuery;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public class SentMessageProcessor extends MessageProcessor{


	public SentMessageProcessor(AbstractMessageFilter local,
			AbstractMessageFilter listen, MessageMatchedListener listener,
			SimilarityAlgorithm algorithm) {
		super(local, listen, listener, algorithm);
	}

	@Override
	protected void matchChanges(CachedMessage msg) {
		
		List<CachedMessage> matchs = new LinkedList<CachedMessage>();
		List<Double> scores = new LinkedList<Double>();
		MessageQueryInfo queryInfo = new MessageQueryInfo();
		queryInfo.setCurrent(msg);
		List<CachedMessage> candidates = this.getLocalPool().queryMessage(queryInfo);
		if(null == candidates || candidates.isEmpty()) return ;
		for(CachedMessage interests:candidates){
			//不跟自己比
			if(interests.getUserId() == msg.getUserId()) continue;
			if(this.getAlgorithm().matched(interests, msg))
			{
				double score = this.getAlgorithm().calcSimilarity(interests, msg);
				if(score > 0.8)
				{
					//getListener().onMessageMatched(interests, msg);
					matchs.add(interests);
					scores.add(new Double(score));
				}
			}
		}
		
		//与消息池里其它消息比一把
		candidates = this.getListenPool().queryMessage(queryInfo);
		if(null == candidates || candidates.isEmpty()) return ;
		for(CachedMessage interests:candidates){
			if(interests.getUserId() == msg.getUserId()) continue;
			if(this.getAlgorithm().matched(interests, msg))
			{
				double score = this.getAlgorithm().calcSimilarity(interests, msg);
				if(score > 0.8)
				{
					//getListener().onMessageMatched(interests, msg);
					matchs.add(interests);
					scores.add(new Double(score));
				}
			}
		}
		
		
		getListener().onMessageMatched(msg, matchs, scores);
	}
	

}
