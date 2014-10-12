package com.xinfan.msgbox.http.service;

import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.service.dao.entity.User;

public class BaseService {
	protected static final String USER_SESSION_KEY = "user_session";
	
	public static User getUserFromSession(){
		return (User) ServiceContext.getRequest().getSession().getAttribute(USER_SESSION_KEY);
	}
}
