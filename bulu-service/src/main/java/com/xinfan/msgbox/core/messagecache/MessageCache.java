package com.xinfan.msgbox.core.messagecache;

import java.util.List;

import com.xinfan.msgbox.core.listener.MessageChangeListener;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;

public interface MessageCache {
	int getMessageCount();
//	List<CachedMessage> getUserMessage(long userId);
	
//	/**
//	 * 获取坐标点position附近meters米范围内的所有消息
//	 * @param position
//	 * @param meters
//	 * @return
//	 */
//	List<CachedMessage> getMessageByDistance(Position position,int meters);
//	List<CachedMessage> getMessageByArea(String areaName);
	
	List<Long> getAllMessageIds();
	
	List<CachedMessage> getMessageByIds(List<Long> ids);
	List<CachedMessage> getAllMessages();
	CachedMessage getMessageById(Long msgId);
	
	boolean addMessage(CachedMessage msg);
	boolean updateMessage(CachedMessage old,CachedMessage msg);
	boolean deleteMessage(CachedMessage msg);
	
	void addMessageChangeListener(MessageChangeListener listener);
	void addMessageFilter(MessageQuery query);
	
	List<CachedMessage> queryMessage(MessageQueryInfo query);
}
