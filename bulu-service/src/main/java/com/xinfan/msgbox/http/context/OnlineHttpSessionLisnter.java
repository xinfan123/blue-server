package com.xinfan.msgbox.http.context;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfan.msgbox.http.service.BaseService;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.entity.User;

public class OnlineHttpSessionLisnter implements HttpSessionListener {

	private static Logger logger = LoggerFactory.getLogger(OnlineHttpSessionLisnter.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		logger.debug("session " + se.getSession().getId() + " is created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		User user = (User) se.getSession().getAttribute(BaseService.USER_SESSION_KEY);
		if (user != null) {
			UserDao userDao = AppContextHolder.getBean(UserDao.class);

			User update = new User();
			update.setUserId(user.getUserId());
			update.setOnline(0);

			userDao.updateByPrimaryKeySelective(update);
		}

		logger.debug("session " + se.getSession().getId() + " is destroyed");

	}

}
