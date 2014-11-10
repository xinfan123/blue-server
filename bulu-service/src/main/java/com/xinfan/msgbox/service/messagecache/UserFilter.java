package com.xinfan.msgbox.service.messagecache;


import com.xinfan.msgbox.service.user.UserCache;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public class UserFilter implements MessageQuery{
	
	private UserCache userCache;
	
	public UserFilter(UserCache u) {
		this.userCache = u;
	}

	@Override
	public void doQuery(MessageQueryInfo queryInfo) {
		
	}

	@Override
	public void onMessageAdded(CachedMessage msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageUpdated(CachedMessage old,CachedMessage msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessageDeleted(CachedMessage msg) {
		// TODO Auto-generated method stub
		
	}
	
}
