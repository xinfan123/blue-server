package com.xinfan.msgbox.core.processor;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.core.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.core.listener.MessageMatchedListener;
import com.xinfan.msgbox.core.messagecache.MessageCache;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;

/**
 * 动态消息处理类，监听静态消息池里消息的变化，与自己的消息进行匹配
 * @author wendell
 *
 */
public class DynamicMessageProcessor extends MessageProcessor{


	public DynamicMessageProcessor(MessageCache local,
			MessageCache listen, MessageMatchedListener listener,
			SimilarityAlgorithm algorithm) {
		super(local, listen, listener, algorithm);
	}

	@Override
	protected void matchChanges(CachedMessage statics) {
		
		List<CachedMessage> matchs = new LinkedList<CachedMessage>();
		List<Double> scores = new LinkedList<Double>();
		MessageQueryInfo queryInfo = new MessageQueryInfo();
		queryInfo.setCurrent(statics);
		List<CachedMessage> candidates = this.getLocalPool().queryMessage(queryInfo);
		if(null == candidates || candidates.isEmpty()) return ;
		for(CachedMessage interests:candidates){
			//不跟自己比
			if(interests.getUserId() == statics.getUserId()) continue;
			if(this.getAlgorithm().matched(interests, statics))
			{
				double score = this.getAlgorithm().calcSimilarity(interests, statics);
				if(score > 0.8)
				{
					//getListener().onMessageMatched(interests, msg);
					matchs.add(interests);
					scores.add(new Double(score));
				}
			}
		}
		getListener().onStaticMsgMatchedDynamicMsgs(statics, matchs, scores);
		
//		queryInfo = new MessageQueryInfo();
//		queryInfo.setCurrent(statics);
//		matchs = new LinkedList<CachedMessage>();
//		scores = new LinkedList<Double>();
//		//与消息池里其它消息比一把
//		candidates = this.getListenPool().queryMessage(queryInfo);
//		if(null == candidates || candidates.isEmpty()) return ;
//		for(CachedMessage interests:candidates){
//			if(interests.getUserId() == statics.getUserId()) continue;
//			if(this.getAlgorithm().matched(interests, statics))
//			{
//				double score = this.getAlgorithm().calcSimilarity(interests, statics);
//				if(score > 0.8)
//				{
//					//getListener().onMessageMatched(interests, msg);
//					matchs.add(interests);
//					scores.add(new Double(score));
//				}
//			}
//		}
//		getListener().onStaticMsgMatchedStaticMsgs(staticMessage, statics, scores)
		
	}
	

}
