package com.xinfan.msgbox.service.dao;

import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserExample;

public class UserDao extends BaseDao<User,UserExample>{

	public User selectByMobile(String mobile) {
		return this.getSqlSession().selectOne(wrapCommand("selectByMobile"), mobile);
	}
   
}