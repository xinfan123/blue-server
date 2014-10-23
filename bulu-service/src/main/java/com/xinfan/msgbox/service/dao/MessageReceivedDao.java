package com.xinfan.msgbox.service.dao;

import java.util.List;
import java.util.Map;

import com.xinfan.msgbox.service.dao.entity.MessageReceived;
import com.xinfan.msgbox.service.dao.entity.MessageReceivedExample;
import com.xinfan.msgbox.service.dao.entity.MessageSend;

public class MessageReceivedDao extends BaseDao<MessageReceived,MessageReceivedExample>{

	public List<MessageReceived> selectListForHttpService(Map<String, String> map) {
		return this.getSqlSession().selectList(wrapCommand("selectListForHttpService"), map);
	}
}