package com.xinfan.msgbox.core.messagecache;

import java.util.Date;

import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.vo.Position;

public interface MessageCenterFacade {
	
	boolean addUser(User user,UserSet userSet);
	
	boolean updateUserProfile(long userId,UserSet userSet);
	
	boolean updateUserPosition(long userId,Position position);
	
	boolean addUserInterestMsg(long userId,Message message);
	
	boolean updateUserInterestMsg(long userId,Message message);
	
	boolean deleteUserInterestMsg(long userId,Message message);
	
	boolean sendMessage(long userId,Message message);
	
	boolean updateMessage(long userId,Message message);
	
	boolean deleteMessage(long userId,Message message);
	//更新消息的有效期
	boolean updateMessageValideTime(long userId,long messageId,Date deadTime);
	
	boolean deleteUser(User user);
}
