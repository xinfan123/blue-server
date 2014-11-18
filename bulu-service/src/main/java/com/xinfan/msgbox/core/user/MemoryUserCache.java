package com.xinfan.msgbox.core.user;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.CachedUser;
import com.xinfan.msgbox.core.vo.Position;
import com.xinfan.msgbox.core.vo.UserProfile;
import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserSentDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageExample;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserExample;
import com.xinfan.msgbox.service.dao.entity.UserSent;
import com.xinfan.msgbox.service.dao.entity.UserSentExample;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.dao.entity.UserSetExample;

public class MemoryUserCache implements UserCache{

	Map<Long, CachedUser> userCache = new ConcurrentHashMap<Long, CachedUser>();
	
	private MessageContext context;
	
	public MemoryUserCache(MessageContext context) {
		//初始化所有的用户
		UserDao userDao = AppContextHolder.getBean(UserDao.class);
		
		UserSetDao userSetDao = AppContextHolder.getBean(UserSetDao.class);
		
		UserSentDao userSentDao = AppContextHolder.getBean(UserSentDao.class);
		
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
			if(sets.size()==1){
				
			
			//用户设置
			UserProfile profile = new UserProfile(sets.get(0));
			CachedUser cuser = new CachedUser(user, profile);
			
			//用户订阅的消息列表，需要取出用户的订阅消息，初始化到interests Cache中
			UserSentExample usExample = new UserSentExample();
			usExample.createCriteria().andUserIdEqualTo(cuser.getUserId());
			List<UserSent> sends = userSentDao.selectByExample(usExample);
			for(UserSent us:sends)
			{
				CachedMessage cm = new CachedMessage();
				cm.setUserId(us.getUserId());
				cm.setOriginalMsg(us.getUserSent());
				cm.setSrcPosition(new Position(us.getGpsx(), us.getGpsy(),us.getReginCode()));
				cm.setTargetPosition(new Position(us.getGpsx(), us.getGpsy(),us.getReginCode()));
				cm.setMessageId(us.getId());
				context.getInterestsCache().addMessage(cm);
			}

			//			List<CachedMessage> caches = new ArrayList<CachedMessage>(interests.size());
			//用户发送消息列表，需要将未失效的消息重新load出来，初始化到message pool中
			MessageExample mexample = new MessageExample();
			mexample.createCriteria().andCreateUserIdEqualTo(cuser.getUserId()).andValidTimeGreaterThan(new Date());
			List<Message> interests =  messageDao.selectByExample(mexample);
			for(Message msg:interests)
			{	
				CachedMessage cm = new CachedMessage();
				cm.setUserId(cuser.getUserId());
				cm.setOriginalMsg(msg.getTitle());
				cm.setSrcPosition(new Position(msg.getGpsx(),msg.getGpsy(),msg.getReginCode()));
				cm.setTargetPosition(new Position("80.80","80.80",msg.getSendArea()));
				cm.setMessageId(msg.getMsgId());
				cm.setDeadTime(null!=msg.getValidTime()?msg.getValidTime():new Date(System.currentTimeMillis()+24*60*60*1000*12));
				cm.setMatchType(msg.getSendType());
				context.getMessagePool().addMessage(cm);
			}
//			context.getInterestsCache().addMessageDirectlly(caches);
			//cuser.setSentMsgIds(sentMsgIds);
			userCache.put(cuser.getUserId(), cuser);
			}
		}
		
		this.context = context;
	}
		@Override
	public int getActiveUserCount() {
		return userCache.size();
	}

	@Override
	public int getOnlineUserCount() {
		return 50;
	}

	@Override
	public boolean updateUserPosition(long userId, Position position) {
		//用户位置改变，只修改用户的订阅消息的位置
		CachedUser user = userCache.get(userId);
		if(null == user) return false;
		
		List<Long> ids = user.getInterestsMsgIds();
		if(null == ids || ids.isEmpty()) return true;
		
		List<CachedMessage> userInterests = context.getInterestsCache().getMessageByIds(ids);
		for(CachedMessage message:userInterests)
		{
			try {
				CachedMessage newMsg = (CachedMessage) message.clone();
				newMsg.setSrcPosition(position);
				context.getInterestsCache().updateMessage(message,newMsg);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		List<CachedMessage> userMessages = context.getMessagePool().getUserMessage(userId);
//		for(CachedMessage message:userMessages)
//		{
//			message.setSrcPosition(position);
//			context.getMessagePool().updateMessage(message);
//		}
		
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
		context.getInterestsCache().updateMessage(context.getInterestsCache()
				.getMessageById(message.getMessageId()),message);
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
		context.getMessagePool().updateMessage(context.getMessagePool().
				getMessageById(message.getMessageId()),message);
		return true;
	}

	@Override
	public boolean deleteMessage(CachedMessage message) {
		context.getMessagePool().deleteMessage(message);
		userCache.get(message.getUserId()).getSentMsgIds().remove(message.getMessageId());
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
		context.getMessagePool().updateMessage(cmessage,cmessage);
		return true;
	}
	@Override
	public Iterable<Entry<Long, CachedUser>> getUserEntrys() {
		return userCache.entrySet();
	}
	@Override
	public boolean deleteUser(long userId) {
		CachedUser cuser = userCache.get(userId);
		if(null == cuser) return false;
		if(!CollectionUtils.isEmpty(cuser.getInterestsMsgIds()))
		{
			for(Long id:cuser.getInterestsMsgIds())
			{
				CachedMessage msg = context.getInterestsCache().getMessageById(id);
				if(null != msg)
				context.getInterestsCache().deleteMessage(msg);
			}
		}
		return true;
	}
}
