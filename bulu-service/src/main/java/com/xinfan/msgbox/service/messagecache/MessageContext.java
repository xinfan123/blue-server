package com.xinfan.msgbox.service.messagecache;

import java.util.Date;

import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.user.SimpleUserCacheCenter;
import com.xinfan.msgbox.service.user.UserCacheCenter;
import com.xinfan.msgbox.vo.Position;

public class MessageContext implements MessageCenterFacade{
	private static MessageContext instance;
	
	private UserCacheCenter userCache;//用户缓存
	
	private InterestsMsgCacheCenter interestsCache;//感兴趣的消息缓存
	
	private SentMsgCacheCenter messagePool;//发送的消息缓存
	
	private MessageContext()
	{
		init();
	}
	
	private void init(){
		interestsCache = new InterestsMsgCacheCenter();
		
		messagePool = new SentMsgCacheCenter();
		
		//初始化所有用户
		userCache = new SimpleUserCacheCenter(this);
		//初始化所有用户的interests列表
	}
	
	public synchronized static MessageContext getInstance()
	{
		if(null == instance)
		{
			instance = new MessageContext();
		}
		return instance;
	}

	public InterestsMsgCacheCenter getInterestsCache() {
		return interestsCache;
	}

	public void setInterestsCache(InterestsMsgCacheCenter interestsCache) {
		this.interestsCache = interestsCache;
	}

	public SentMsgCacheCenter getMessagePool() {
		return messagePool;
	}

	public void setMessagePool(SentMsgCacheCenter messagePool) {
		this.messagePool = messagePool;
	}

	public UserCacheCenter getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCacheCenter userCache) {
		this.userCache = userCache;
	}

	@Override
	public boolean addUser(User user, UserSet userSet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserProfile(long userId, UserSet userSet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserPosition(long userId, Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserInterestMsg(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserInterestMsg(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserInterestMsg(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendMessage(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMessage(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(long userId, Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMessageValideTime(long userId, long messageId,
			Date deadTime) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
