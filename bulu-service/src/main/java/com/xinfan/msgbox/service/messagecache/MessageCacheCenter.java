package com.xinfan.msgbox.service.messagecache;

import java.util.List;

import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.Position;

public interface MessageCacheCenter {
	int getMessageCount();
	List<CachedMessage> getUserMessage(long userId);
	
	/**
	 * 获取坐标点position附近meters米范围内的所有消息
	 * @param position
	 * @param meters
	 * @return
	 */
	List<CachedMessage> getMessageByDistance(Position position,int meters);
	List<CachedMessage> getMessageByArea(String areaName);
	List<CachedMessage> getMessageByIds(List<Long> ids);
	
	boolean addMessage(CachedMessage msg);
	boolean updateMessage(CachedMessage msg);
	boolean deleteMessage(CachedMessage msg);
	
}
