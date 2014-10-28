package com.xinfan.msgbox.service.messagecache;

import java.util.Date;

import com.xinfan.msgbox.service.algorithm.SimpleSimilarityAlgorithm;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.processor.MessageProcessor;
import com.xinfan.msgbox.service.user.SimpleUserCacheCenter;
import com.xinfan.msgbox.service.user.UserCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;
import com.xinfan.msgbox.vo.UserProfile;

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

		new MessageProcessor(interestsCache, messagePool, new MessageMatchedListener() {
			
			@Override
			public void onMessageMatched(CachedMessage interests, CachedMessage message) {
				System.out.println(interests.getOriginalMsg() + " matchs " + message.getOriginalMsg() + " send Message to " + interests.getUserId());
			}
		}, new SimpleSimilarityAlgorithm()).start();
		
		interestsCache.start();
		messagePool.start();
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
		UserProfile profile = new UserProfile(userSet);
		CachedUser cuser = new CachedUser(user, profile);
		userCache.addUser(cuser);
		return false;
	}

	@Override
	public boolean updateUserProfile(long userId, UserSet userSet) {
		User user = new User();
		user.setUserId(userId);
		UserProfile profile = new UserProfile(userSet);
		CachedUser cuser = new CachedUser(user, profile);
		return userCache.updateUserProfile(cuser);
	}

	@Override
	public boolean updateUserPosition(long userId, Position position) {
		return userCache.updateUserPosition(userId, position);
	}

	@Override
	public boolean addUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.addUserInterestsMsg(userId, cmessage);
	}

	@Override
	public boolean updateUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.updateUserInterestsMsg(userId, cmessage);
	}

	@Override
	public boolean deleteUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.deleteUserInterestsMsg(userId,cmessage);
	}



	@Override
	public boolean sendMessage(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.sendMessage(cmessage);
	}

	@Override
	public boolean updateMessage(long userId, Message message) {

		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.updateMessage(cmessage);
	}

	@Override
	public boolean deleteMessage(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.deleteMessage(cmessage);
	}

	@Override
	public boolean updateMessageValideTime(long userId, long messageId,
			Date deadTime) {
		CachedMessage cmessage = new CachedMessage();
		cmessage.setUserId(userId);
		cmessage.setMessageId(messageId);
		return userCache.updateMessageValideTime(userId,messageId,deadTime);
	}
	
	private CachedMessage constructCachedMsg(long userId, Message message) {
		CachedMessage cmessage = new CachedMessage();
		cmessage.setUserId(userId);
		cmessage.setMessageId(message.getMsgId());
		cmessage.setOriginalMsg(message.getContext());
		cmessage.setSrcPosition(new Position(message.getGpsx(),message.getGpsy()));
		cmessage.setDeadTime(message.getValidTime());
		return cmessage;
	}
}
