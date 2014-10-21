package com.xinfan.msgbox.http.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.http.service.util.BeanUtils;
import com.xinfan.msgbox.http.service.vo.param.SendMessageParam;
import com.xinfan.msgbox.http.service.vo.param.UserMessageListParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.MessageListResult;
import com.xinfan.msgbox.http.service.vo.result.MessageResult;
import com.xinfan.msgbox.http.service.vo.result.MessageSendDetailVO;
import com.xinfan.msgbox.http.service.vo.result.MessageSendListResult;
import com.xinfan.msgbox.http.service.vo.result.MessageSendSummaryVO;
import com.xinfan.msgbox.http.service.vo.result.MessageVO;
import com.xinfan.msgbox.http.util.PageUtils;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.MessageReceivedDao;
import com.xinfan.msgbox.service.dao.MessageSendDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageReceived;
import com.xinfan.msgbox.service.dao.entity.MessageSend;

public class MessageGetService {
	@Autowired
	MessageReceivedDao messageReceivedDao;
	@Autowired
	MessageDao messageDao;
	@Autowired
	MessageSendDao messageSendDao;

	/**
	 * 用户发信列表获取接口
	 * 
	 * @param param
	 * @return
	 */
	public MessageSendListResult getUserSendMessageList(UserMessageListParam param) throws Exception {

		if (param.getUserId() == null || param.getUserId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}

		Map<String, String> map = org.apache.commons.beanutils.BeanUtils.describe(param);

		map.put("orderBy", "create_time");

		PageUtils.calCurrentRow(map);

		List<MessageSend> list = messageSendDao.selectListForHttpService(map);

		List<MessageSendSummaryVO> rsList = new ArrayList<MessageSendSummaryVO>();
		if (!CollectionUtils.isEmpty(list)) {
			for (MessageSend ms : list) {
				MessageSendSummaryVO rrs = new MessageSendSummaryVO();
				BeanUtils.copyProperties(rrs, ms);
				Message message = messageDao.selectByPrimaryKey(ms.getMsgId());
				if (message != null) {
					BeanUtils.copyProperties(rrs, message);
				}
				rsList.add(rrs);
			}
		}

		MessageSendListResult rs = new MessageSendListResult();
		rs.setList(rsList);
		rs.setResult(BaseResult.SUCCESS);
		return rs;
	}

	/**
	 * 用户收信列表获取接口
	 * 
	 * @param param
	 * @return
	 */
	public MessageListResult getUserRecievedMessageList(UserMessageListParam param) throws Exception {
		if (param.getUserId() == null || param.getUserId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}

		// pubish_time

		Map<String, String> map = org.apache.commons.beanutils.BeanUtils.describe(param);

		map.put("orderBy", "pubish_time");

		PageUtils.calCurrentRow(map);

		List<MessageSend> list = messageReceivedDao.selectListForHttpService(map);

		List<MessageVO> rsList = new ArrayList<MessageVO>();
		if (!CollectionUtils.isEmpty(list)) {
			for (MessageSend ms : list) {
				MessageVO rrs = new MessageVO();
				BeanUtils.copyProperties(rrs, ms);
				Message message = messageDao.selectByPrimaryKey(ms.getMsgId());
				if (message != null) {
					BeanUtils.copyProperties(rrs, message);
				}
				rsList.add(rrs);
			}
		}
		MessageListResult rs = new MessageListResult();
		rs.setList(rsList);
		rs.setResult(BaseResult.SUCCESS);
		return rs;
	}

	/**
	 * 获取某条信息接口
	 * 
	 * @param param
	 * @return
	 */
	public MessageResult getMessage(SendMessageParam param) throws Exception {
		if (param.getMsgId() == null || param.getMsgId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}

		MessageVO messageVO = new MessageVO();
		Message message = messageDao.selectByPrimaryKey(param.getMsgId());
		if (message == null) {
			return new BaseResult().paramIllgal("信息不存在");
		}
		BeanUtils.copyProperties(messageVO, message);
		MessageSend send = messageSendDao.selectByPrimaryKey(param.getMsgId());
		if (send != null) {
			BeanUtils.copyProperties(messageVO, message);
		}
/*		MessageReceived recived = messageReceivedDao.selectByPrimaryKey(param.getMsgId());
		if (recived != null) {
			BeanUtils.copyProperties(messageVO, recived);
		}*/

		MessageResult rs = new MessageResult();
		rs.setMessage(messageVO);
		rs.setMsg("获取消息成功");
		return rs;
	}

}
