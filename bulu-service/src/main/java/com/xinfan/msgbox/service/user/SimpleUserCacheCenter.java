package com.xinfan.msgbox.service.user;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageExample;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserExample;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.dao.entity.UserSetExample;
import com.xinfan.msgbox.service.messagecache.MessageContext;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;
import com.xinfan.msgbox.vo.UserProfile;

public class SimpleUserCacheCenter implements UserCacheCenter{

	Map<Long, CachedUser> userCache = new HashMap<Long, CachedUser>();
	
	private MessageContext context;
	
	public SimpleUserCacheCenter(MessageContext context) {
		//初始化所有的用户
		UserDao userDao = AppContextHolder.getBean(UserDao.class);
		
		UserSetDao userSetDao = AppContextHolder.getBean(UserSetDao.class);
		
		MessageDao messageDao = AppContextHolder.getBean(MessageDao.class);
		
		//7天以上没登录用户先不进来
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		
		UserExample example = new UserExample();
		example.createCriteria().andLoginTimeGreaterThan(calendar.getTime());
		List<User> users = userDao.selectByExample(example);
		for(User user:users)
		{
			UserSetExample setExample = new UserSetExample();
			setExample.createCriteria().andUserIdEqualTo(user.getUserId());
			List<UserSet> sets = userSetDao.selectByExample(setExample);
			
			//用户设置
			UserProfile profile = new UserProfile(sets.get(0));
			CachedUser cuser = new CachedUser(user, profile);
			
			//用户订阅的消息列表，需要取出用户的订阅消息，初始化到interests Cache中
			//cuser.setInterestsMsgIds();
			MessageExample mexample = new MessageExample();
			mexample.createCriteria().andCreateUserIdEqualTo(cuser.getUserId());
			List<Message> interests =  messageDao.selectByExample(mexample);
			List<CachedMessage> caches = new ArrayList<CachedMessage>(interests.size());
			for(Message interest:interests)
			{
				CachedMessage cm = new CachedMessage();
				cm.setUserId(cuser.getUserId());
				cm.setOriginalMsg(interest.getContext());
				cm.setSrcPosition(new Position("",""));//TODO
				cm.setTargetPosition(new Position("",""));
				cm.setMessageId(interest.getMsgId());
				caches.add(cm);
			}
			
			context.getInterestsCache().addMessageDirectlly(caches);
			//用户发送消息列表，需要将未失效的消息重新load出来，初始化到message pool中
			//cuser.setSentMsgIds(sentMsgIds);
			userCache.put(cuser.getUserId(), cuser);
		}
		
		this.context = context;
	}
	
	@Override
	public int getActiveUserCount() {
		return 100;
	}

	@Override
	public int getOnlineUserCount() {
		return 50;
	}

	@Override
	public boolean updateUserPosition(long userId, Position position) {
		List<CachedMessage> userInterests = context.getInterestsCache().getUserMessage(userId);
		for(CachedMessage message:userInterests)
		{
			message.setSrcPosition(position);
			context.getInterestsCache().updateMessage(message);
		}
		
		List<CachedMessage> userMessages = context.getMessagePool().getUserMessage(userId);
		for(CachedMessage message:userMessages)
		{
			message.setSrcPosition(position);
			context.getMessagePool().updateMessage(message);
		}
		
		return true;
	}

	@Override
	public boolean addUserInterestsMsg(long userId, CachedMessage message) {
		context.getInterestsCache().addMessage(message);
		userCache.get(userId).addInterestsMsg(message);
		return true;
	}

	@Override
	public boolean updateUserInterestsMsg(long userId, CachedMessage message) {
		context.getInterestsCache().updateMessage(message);
		return true;
	}

	@Override
	public boolean deleteUserInterestsMsg(long userId, CachedMessage message) {
		context.getInterestsCache().deleteMessage(message);
		userCache.get(userId).removeInterestsMsg(message);
		return true;
	}

	@Override
	public boolean sendMessage(CachedMessage message) {
		context.getMessagePool().addMessage(message);
		userCache.get(message.getUserId()).addSentMsg(message);
		return true;
	}

	@Override
	public boolean updateMessage(CachedMessage message) {
		context.getMessagePool().updateMessage(message);
		return true;
	}

	@Override
	public boolean deleteMessage(CachedMessage message) {
		context.getMessagePool().deleteMessage(message);
		userCache.get(message.getUserId()).getSentMsgIds();
		return true;
	}

	@Override
	public boolean addUser(CachedUser user) {
		userCache.put(user.getUserId(), user);
		return true;
	}

	@Override
	public boolean updateUserProfile(CachedUser user) {
		CachedUser cuser = userCache.get(user.getUserId());
		if(null == cuser) return false;
		cuser.setProfile(user.getProfile());
		userCache.put(cuser.getUserId(), cuser);
		return true;
	}

	@Override
	public boolean updateMessageValideTime(long userId, long messageId,
			Date deadTime) {
		CachedMessage cmessage = context.getMessagePool().getMessageById(messageId);
		cmessage.setDeadTime(deadTime);
		context.getMessagePool().updateMessage(cmessage);
		return true;
	}
}
