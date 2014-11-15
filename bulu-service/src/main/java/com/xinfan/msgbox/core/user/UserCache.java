package com.xinfan.msgbox.core.user;

import java.util.Date;
import java.util.Map.Entry;

import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;

public interface UserCache {
	
	int getActiveUserCount();
	int getOnlineUserCount();
	
	Iterable<Entry<Long, CachedUser>> getUserEntrys();
	
	boolean addUser(CachedUser user);
	boolean updateUserProfile(CachedUser user);
	boolean updateUserPosition(long userId,Position position);
	boolean deleteUser(long userId);
	
	boolean addUserInterestsMsg(long userId,CachedMessage message);
	boolean updateUserInterestsMsg(long userId,CachedMessage message);
	boolean deleteUserInterestsMsg(long userId,CachedMessage message);
	
	boolean sendMessage(CachedMessage message);
	boolean updateMessage(CachedMessage message);
	boolean deleteMessage(CachedMessage message);
	boolean updateMessageValideTime(long userId, long messageId, Date deadTime);
}
