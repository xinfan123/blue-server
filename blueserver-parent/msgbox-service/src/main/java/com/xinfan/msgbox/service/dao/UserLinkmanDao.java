package com.xinfan.msgbox.service.dao;

import com.xinfan.msgbox.service.dao.entity.UserLinkman;
import com.xinfan.msgbox.service.dao.entity.UserLinkmanExample;
import com.xinfan.msgbox.service.dao.entity.UserLinkmanKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public class UserLinkmanDao extends BaseDao<UserLinkman,UserLinkmanExample>{

	public List<UserLinkman> selectListForHttpService(Map<String, String> map) {
		return this.getSqlSession().selectList(wrapCommand("selectListForHttpService"), map);
	}
   
}