package com.xinfan.service.test;

import java.util.Date;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.entity.User;


public class DaoTest extends BaseTest{
	public static void main(String[] args) {
		DaoTest test = new DaoTest();
		test.initSpring();
		
		User user =	new User();
		user.setMobile("15030544429");
		user.setRegTime(new Date());
		AppContextHolder.getBean(UserDao.class).insertSelective(user);
		System.out.println(user.getUserId());
	}
}
