package com.xinfan.msgbox.service.messagecache;

import com.xinfan.msgbox.service.user.SimpleUserCacheCenter;
import com.xinfan.msgbox.service.user.UserCacheCenter;

public class MessageContext {
	private static MessageContext instance;
	
	private UserCacheCenter userCache;//用户缓存
	
	private InterestsMsgCacheCenter interestsCache;//感兴趣的消息缓存
	
	private SentMsgCacheCenter messagePool;//发送的消息缓存
	
	private MessageContext()
	{
		init();
	}
	
	private void init(){
		//初始化所有用户
		userCache = new SimpleUserCacheCenter();
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
	
}
