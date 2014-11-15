package com.xinfan.msgbox.core.processor;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.core.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.core.listener.MessageMatchedListener;
import com.xinfan.msgbox.core.messagecache.MessageCache;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public class InterestsMessageProcessor extends MessageProcessor{

	public InterestsMessageProcessor(MessageCache local,
			MessageCache listen, MessageMatchedListener listener,
			SimilarityAlgorithm algorithm) {
		super(local, listen, listener, algorithm);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void matchChanges(CachedMessage msg) {
//		for(CachedMessage msg:changedMsgs)
//		{
//			for(Entry<Long, CachedMessage> entry:local)
			List<CachedMessage> matchs = new LinkedList<CachedMessage>();
			List<Double> scores = new LinkedList<Double>();
			MessageQueryInfo queryInfo = new MessageQueryInfo();
			queryInfo.setCurrent(msg);
			List<CachedMessage> candidates = this.getLocalPool().queryMessage(queryInfo);
			if(null == candidates || candidates.isEmpty()) return ;
			System.out.println(System.currentTimeMillis()/1000 + "'s start matching " + candidates.size() + " messages" );
			for(CachedMessage interests:candidates)
			{
				double score = this.getAlgorithm().calcSimilarity(interests, msg);
				if(score > 0.8)
				{
					//getListener().onMessageMatched(interests, msg);
					matchs.add(interests);
					scores.add(new Double(score));
				}
			}
			System.out.println(System.currentTimeMillis()/1000 + "'s end matching " + candidates.size() + " messages" );
			getListener().onMessageMatched(msg, matchs, scores);
//		}
	}
	
}
