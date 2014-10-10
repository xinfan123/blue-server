package com.xinfan.msgbox.service.dao;

import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.service.dao.entity.MessageSend;
import com.xinfan.msgbox.service.dao.entity.MessageSendExample;

public class MessageSendDao extends BaseDao<MessageSend,MessageSendExample>{

	public List<MessageSend> selectListForHttpService(Map<String, String> map) {
		return this.getSqlSession().selectList(wrapCommand("selectListForHttpService"), map);
	}
}