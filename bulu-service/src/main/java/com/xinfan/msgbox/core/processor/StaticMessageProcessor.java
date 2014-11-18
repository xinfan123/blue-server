package com.xinfan.msgbox.core.processor;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.core.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.core.listener.MessageMatchedListener;
import com.xinfan.msgbox.core.messagecache.MessageCache;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;

/**
 * 静态消息的处理类，监听动态消息池的变化，与自己的消息进行匹配
 * @author wendell
 *
 */
public class StaticMessageProcessor extends MessageProcessor{

	public StaticMessageProcessor(MessageCache local,
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
			for(CachedMessage staticMsg:candidates)
			{
				double score = this.getAlgorithm().calcSimilarity(staticMsg, msg);
				if(score > 0.8)
				{
					//getListener().onMessageMatched(interests, msg);
					matchs.add(staticMsg);
					scores.add(new Double(score));
				}
			}
			System.out.println(System.currentTimeMillis()/1000 + "'s end matching " + candidates.size() + " messages" );
			
			getListener().onDynamicMsgMatchedStaticMsgs(msg, matchs, scores);
			
			//与动态消息匹配一把

			queryInfo = new MessageQueryInfo();
			queryInfo.setCurrent(msg);
			candidates = this.getListenPool().queryMessage(queryInfo);
			if(null == candidates || candidates.isEmpty()) return ;
			
			matchs = new LinkedList<CachedMessage>();
			scores = new LinkedList<Double>();

			for(CachedMessage dynamics:candidates){
				if(dynamics.getUserId() == msg.getUserId()) continue;
				if(this.getAlgorithm().matched(dynamics, msg))
				{
					double score = this.getAlgorithm().calcSimilarity(dynamics, msg);
					if(score > 0.8)
					{
						//getListener().onMessageMatched(interests, msg);
						matchs.add(dynamics);
						scores.add(new Double(score));
					}
				}
			}
			getListener().onDynamicMsgMatchedDynamicMsgs(msg, matchs, scores);
//		}
	}
	
}
