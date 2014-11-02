package com.xinfan.msgbox.service.messagecache;

import java.util.List;

import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.service.user.UserCache;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public class UserFilter extends AbstractMessageFilter{
	
	private UserCache userCache;

	public UserFilter(MessageCache m,UserCache u) {
		super(m);
		userCache = u;
	}

	@Override
	public List<CachedMessage> queryMessage(MessageQueryInfo queryInfo) {
		//TODO 收消息数达到上限的用户，不进行匹配
		return super.queryMessage(queryInfo);
	}
	
}
