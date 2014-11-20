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
		
		getListenPool().addMessageChangeListener(this);
		
		// TODO Auto-generated constructor stub
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
		
		
//		}
	}
	
}
