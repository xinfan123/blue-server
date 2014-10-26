package com.xinfan.msgbox.service.user;

import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;

public interface UserCacheCenter {
	
	int getActiveUserCount();
	int getOnlineUserCount();
	
	boolean addUser(CachedUser user);
	boolean updateUserProfile(CachedUser user);
	boolean updateUserPosition(long userId,Position position);
	
	boolean addUserInterestsMsg(long userId,CachedMessage message);
	boolean updateUserInterestsMsg(long userId,CachedMessage message);
	boolean deleteUserInterestsMsg(long userId,long messageId);
	
	boolean sendMessage(CachedMessage message);
	boolean updateMessage(CachedMessage message);
	boolean deleteMessage(CachedMessage message);
}
