package com.xinfan.msgbox.core.listener;

import java.util.List;

import com.xinfan.msgbox.core.vo.CachedMessage;

public interface MessageMatchedListener {
	@Deprecated
	void onMessageMatched(CachedMessage interests,CachedMessage message);
	/**
	 * 
	 * @param staticMessage 静态消息本身
	 * @param matchs 与该静态消息匹配的动态消息列表
	 * @param scores 匹配的分数
	 */
	void onStaticMsgMatchedDynamicMsgs(CachedMessage staticMessage,List<CachedMessage> dynamics,List<Double> scores);
	
	/**
	 * 
	 * @param staticMessage 静态消息本身
	 * @param matchs 与该静态消息匹配的静态消息列表
	 * @param scores 匹配的分数
	 */
	void onStaticMsgMatchedStaticMsgs(CachedMessage staticMessage,List<CachedMessage> statics,List<Double> scores);
	
	
	
	/**
	 * 
	 * @param dynamicMessage 动态消息本身
	 * @param matchs 与该动态消息匹配的动态消息列表
	 * @param scores 匹配的分数
	 */
	void onDynamicMsgMatchedDynamicMsgs(CachedMessage dynamicMessage,List<CachedMessage> dynamics,List<Double> scores);
	
	/**
	 * 
	 * @param dynamicMessage 动态消息本身
	 * @param matchs 与该动态消息匹配的静态消息列表
	 * @param scores 匹配的分数
	 */
	void onDynamicMsgMatchedStaticMsgs(CachedMessage dynamicMessage,List<CachedMessage> statics,List<Double> scores);
	
}
