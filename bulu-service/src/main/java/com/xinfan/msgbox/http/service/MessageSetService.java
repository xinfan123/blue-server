package com.xinfan.msgbox.http.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.http.service.util.BeanUtils;
import com.xinfan.msgbox.http.service.vo.param.MessageRevDelParam;
import com.xinfan.msgbox.http.service.vo.param.RevMessageReadParam;
import com.xinfan.msgbox.http.service.vo.param.SendMessageParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.util.BizUtils;
import com.xinfan.msgbox.http.util.TimeUtils;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.MessageReceivedDao;
import com.xinfan.msgbox.service.dao.MessageSendDao;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserVipDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageReceived;
import com.xinfan.msgbox.service.dao.entity.MessageSend;
import com.xinfan.msgbox.service.dao.entity.UserBalance;
import com.xinfan.msgbox.service.util.SeqFactory;

public class MessageSetService {

	@Autowired
	UserDao userDao;

	@Autowired
	UserBalanceDao userBalanceDao;

	@Autowired
	UserVipDao userVipDao;

	@Autowired
	MessageDao messageDao;

	@Autowired
	MessageSendDao messageSendDao;

	@Autowired
	MessageReceivedDao messageReceivedDao;

	/**
	 * 发布信息接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult addMessage(SendMessageParam param) throws Exception {

		if (param.getCreateUserId() == null || param.getCreateUserId() < 0) {
			return new BaseResult().paramIllgal("创建用户ID不能为空");
		}
		if (StringUtils.isEmpty(param.getTitle())) {
			return new BaseResult().paramIllgal("信息标题不能为空");
		}

		// 写入信息表
		Message msg = new Message();
		BeanUtils.copyProperties(msg, param);
		msg.setCreateTime(new Date());
		msg.setMsgStatus(2);
		msg.setRefreshCount(1);
		msg.setRefreshTime(new Date());
		msg.setSendDistance(BizUtils.getMessageDistanceValue(param.getSendType()));
		msg.setSendArea(param.getSendArea());
		msg.setMsgId(SeqFactory.getInstance().getSeqMessage());

		Date validTime = TimeUtils.getValidTime(new Date(), param.getDurationTime());
		msg.setValidTime(validTime);

		messageDao.insertSelective(msg);

		// 写入发信表
		MessageSend send = new MessageSend();
		send.setCreateTime(msg.getCreateTime());
		send.setMsgId(msg.getMsgId());
		send.setMsgStatus(msg.getMsgStatus());

		send.setNewReplyForSend(0);
		send.setPublishType(param.getPublishType() == null ? 1 : param.getPublishType());
		send.setPublishTo(param.getPublishTo());
		UserBalance userBalance = userBalanceDao.selectByPrimaryKey(msg.getCreateUserId());
		send.setSendCurrentCredit(userBalance.getUserCredit());
		send.setSendTime(msg.getCreateTime());
		send.setSendUserId(msg.getCreateUserId());

		send.setPublishCount(0);
		send.setReadCount(0);

		messageSendDao.insertSelective(send);

		// 插入发送人列表
		/*
		 * MessageReceived recevied = new MessageReceived();
		 * recevied.setMsgId(msg.getMsgId());
		 * recevied.setReceivedUserid(send.getSendUserId());
		 * recevied.setSendUserid(send.getSendUserId());
		 * recevied.setSendNewReply(0); recevied.setReceivedNewReply(1);
		 * recevied.setReceivedStaus(1); recevied.setDeleteTime(new Date());
		 * recevied.setReadTime(new Date()); recevied.setPubishTime(new Date());
		 * 
		 * messageReceivedDao.insertSelective(recevied);
		 */

		MessageContext.getInstance().sendMessage(msg.getCreateUserId(), msg);

		// 新启动线程，推送
		// TODO
		return new BaseResult().success("信息发布成功");
	}

	/**
	 * 删除信息接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult deleteMessage(SendMessageParam param) {
		if (param.getMsgId() == null || param.getMsgId() <= 0) {
			return new BaseResult().paramIllgal("信息编号不能为空");
		}
		// 更改信息状态
		Message message = messageDao.selectByPrimaryKey(param.getMsgId());
		if (message == null) {
			return new BaseResult().paramIllgal("信息不存在");
		}
		Message message_ = new Message();
		message_.setMsgId(message.getMsgId());
		message_.setMsgStatus(4);
		messageDao.updateByPrimaryKeySelective(message_);
		// 更改信息发送状态
		MessageSend send = new MessageSend();
		send.setMsgId(message.getMsgId());
		send.setMsgStatus(4);
		messageSendDao.updateByPrimaryKeySelective(send);

		MessageContext.getInstance().deleteMessage(message.getCreateUserId(), message);

		return new BaseResult().success("信息删除成功");
	}

	/**
	 * 删除信息接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult deleteRevMessage(MessageRevDelParam param) {

		if (param.getPublishId() == null || param.getPublishId() <= 0) {
			return new BaseResult().paramIllgal("信息编号不能为空");
		}

		MessageReceived update = new MessageReceived();
		update.setPublishId(param.getPublishId());
		update.setReceivedStaus(2);
		update.setDeleteTime(new Date());

		messageReceivedDao.updateByPrimaryKeySelective(update);

		return new BaseResult().success("信息删除成功");
	}

	public BaseResult updateRevMessageReadState(RevMessageReadParam param) throws Exception {
		if (param.getMsgId() == null) {
			return new BaseResult().paramIllgal("消息id不存在");
		}

		if (param.getPublishId() == null) {
			return new BaseResult().paramIllgal("收消息id不存在");
		}

		MessageReceived messageReceived = new MessageReceived();
		messageReceived.setPublishId(param.getPublishId());
		messageReceived.setReceivedStaus(1);
		messageReceived.setReadTime(new Date());
		messageReceivedDao.updateByPrimaryKeySelective(messageReceived);

		MessageSend messageSend = messageSendDao.selectByPrimaryKey(param.getMsgId());

		MessageSend updateMessageSend = new MessageSend();
		updateMessageSend.setMsgId(param.getMsgId());
		updateMessageSend.setReadCount(messageSend.getReadCount() + 1);

		this.messageSendDao.updateByPrimaryKeySelective(updateMessageSend);

		BaseResult rs = new BaseResult().success("成功");
		return rs;
	}

	/**
	 * 重发用户设置接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult reSendMessage(SendMessageParam param) {
		if (param.getMsgId() == null || param.getMsgId() <= 0) {
			return new BaseResult().paramIllgal("信息编号不能为空");
		}

		Message message = messageDao.selectByPrimaryKey(param.getMsgId());
		if (message == null) {
			return new BaseResult().paramIllgal("信息不存在");
		}
		// 延长有效期
		message.getCreateTime();

		Date valTime = TimeUtils.getValidTime(new Date(), message.getDurationTime());
		message.setValidTime(valTime);

		message.setRefreshCount(message.getRefreshCount() + 1);
		message.setRefreshTime(new Date());

		messageDao.updateByPrimaryKeySelective(message);

		MessageContext.getInstance().updateMessageValideTime(message.getCreateUserId(), message);

		// 新启动线程，推送
		return new BaseResult().success("信息重发成功");
	}
}
