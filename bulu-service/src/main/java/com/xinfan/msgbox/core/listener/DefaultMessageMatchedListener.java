package com.xinfan.msgbox.core.listener;

import java.util.Date;
import java.util.List;

import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.MessageReceivedDao;
import com.xinfan.msgbox.service.dao.MessageSendDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.entity.MessageReceived;
import com.xinfan.msgbox.service.dao.entity.MessageSend;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.push.PushServiceFactory;

public class DefaultMessageMatchedListener implements MessageMatchedListener {

	@Override
	@Deprecated
	public void onMessageMatched(final CachedMessage interests, final CachedMessage message) {

		new Thread() {

			@Override
			public void run() {

				System.out.println(Thread.currentThread().getName() + "send message :" + message.getOriginalMsg() + " to " + interests.getUserId());

				MessageSendDao sendDao = AppContextHolder.getBean(MessageSendDao.class);
				MessageReceivedDao receivedDao = AppContextHolder.getBean(MessageReceivedDao.class);
				UserDao userDao = AppContextHolder.getBean(UserDao.class);

				MessageSend dbSend = sendDao.selectByPrimaryKey(message.getMessageId());

				MessageSend updateSend = new MessageSend();
				updateSend.setMsgId(message.getMessageId());
				updateSend.setPublishStatus(1);
				updateSend.setPublishTime(new Date());
				updateSend.setPublishCount(dbSend.getPublishCount() + 1);
				sendDao.updateByPrimaryKeySelective(updateSend);

				MessageReceived newReceive = new MessageReceived();
				newReceive.setMsgId(message.getMessageId());
				newReceive.setPubishTime(new Date());
				newReceive.setReceivedUserid(interests.getUserId());
				newReceive.setSendUserid(message.getUserId());
				newReceive.setSendNewReply(0);
				newReceive.setReceivedNewReply(0);
				newReceive.setReceivedStaus(0);

				receivedDao.insertSelective(newReceive);

				User user = userDao.selectByPrimaryKey(interests.getUserId());

				PushServiceFactory.getDefaultService().pushMessageTip(user.getCid(), user.getUserId(), message.getOriginalMsg());
			}

		}.start();

	}

	@Override
	public void onMessageMatched(CachedMessage message,
			List<CachedMessage> matchs, List<Double> scores) {
		// TODO Auto-generated method stub
		System.out.println(message.getOriginalMsg() + " matched + "+matchs.size() + " messages");
		for(int i=0;i<matchs.size();i++)
		{
			System.out.println(message.getOriginalMsg() + " vs " + matchs.get(i).getOriginalMsg() + " score: " + scores.get(i));
		}
		
	}
}
