package com.xinfan.msgbox.service.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserExample;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.dao.entity.UserSetExample;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;
import com.xinfan.msgbox.vo.UserProfile;

public class SimpleUserCacheCenter implements UserCacheCenter{

	Map<Long, CachedUser> userCache = new HashMap<Long, CachedUser>();
	
	public SimpleUserCacheCenter() {
		//初始化所有的用户
		UserDao userDao = AppContextHolder.getBean(UserDao.class);
		
		UserSetDao userSetDao = AppContextHolder.getBean(UserSetDao.class);
		
		UserExample example = new UserExample();
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
			
			//用户发送消息列表，需要将未失效的消息重新load出来，初始化到message pool中
			//cuser.setSentMsgIds(sentMsgIds);
			userCache.put(cuser.getUserId(), cuser);
		}
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserInterestsMsg(long userId, CachedMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserInterestsMsg(long userId, CachedMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserInterestsMsg(long userId, long messageId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendMessage(CachedMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMessage(CachedMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(CachedMessage message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(CachedUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserProfile(CachedUser user) {
		// TODO Auto-generated method stub
		return false;
	}
}
