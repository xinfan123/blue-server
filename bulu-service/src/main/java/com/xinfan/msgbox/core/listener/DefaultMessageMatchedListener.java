package com.xinfan.msgbox.core.listener;

import java.util.Date;
import java.util.List;

import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.service.dao.MessageReceivedDao;
import com.xinfan.msgbox.service.dao.MessageSendDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.entity.MessageReceived;
import com.xinfan.msgbox.service.dao.entity.MessageSend;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.push.PushServiceFactory;
import com.xinfan.msgbox.service.util.SeqFactory;

public class DefaultMessageMatchedListener implements MessageMatchedListener {

	@Override
	public void onStaticMsgMatchedDynamicMsgs(final CachedMessage sourceStaticMessage, List<CachedMessage> targetDynamicMsgs, List<Double> scores) {

		for (int i = 0; i < targetDynamicMsgs.size(); i++) {

			final CachedMessage targetDynamicMsg = targetDynamicMsgs.get(i);

			MessageContext.getInstance().getThreadPool().runInThread(new Thread() {

				@Override
				public void run() {

					MessageSendDao sendDao = AppContextHolder.getBean(MessageSendDao.class);
					MessageReceivedDao receivedDao = AppContextHolder.getBean(MessageReceivedDao.class);
					UserDao userDao = AppContextHolder.getBean(UserDao.class);

					MessageSend dbSend = sendDao.selectByPrimaryKey(targetDynamicMsg.getMessageId());

					MessageSend updateSend = new MessageSend();
					updateSend.setMsgId(targetDynamicMsg.getMessageId());
					updateSend.setPublishStatus(1);
					updateSend.setPublishTime(new Date());
					updateSend.setPublishCount(dbSend.getPublishCount() + 1);
					sendDao.updateByPrimaryKeySelective(updateSend);

					MessageReceived newReceive = new MessageReceived();
					newReceive.setPublishId(SeqFactory.getInstance().getSeqReceive());
					newReceive.setMsgId(targetDynamicMsg.getMessageId());
					newReceive.setPubishTime(new Date());
					newReceive.setReceivedUserid(targetDynamicMsg.getUserId());
					newReceive.setSendUserid(sourceStaticMessage.getUserId());
					newReceive.setSendNewReply(0);
					newReceive.setReceivedNewReply(0);
					newReceive.setReceivedStaus(0);

					receivedDao.insertSelective(newReceive);

					User user = userDao.selectByPrimaryKey(targetDynamicMsg.getUserId());

					PushServiceFactory.getDefaultService().pushMessageTip(user.getCid(), user.getUserId(), targetDynamicMsg.getOriginalMsg());
				}
			});
		}
	}

	@Override
	public void onStaticMsgMatchedStaticMsgs(CachedMessage staticMessage, List<CachedMessage> statics, List<Double> scores) {

	}

	@Override
	public void onDynamicMsgMatchedDynamicMsgs(final CachedMessage sourceDynamicMsg, List<CachedMessage> targetDynamicMsgs, List<Double> scores) {
		for (int i = 0; i < targetDynamicMsgs.size(); i++) {
			System.out.println(sourceDynamicMsg.getOriginalMsg() + " vs " + targetDynamicMsgs.get(i).getOriginalMsg() + " score: " + scores.get(i));

			final CachedMessage targetDynamicMsg = targetDynamicMsgs.get(i);

			MessageContext.getInstance().getThreadPool().runInThread(new Thread() {

				@Override
				public void run() {

					MessageSendDao sendDao = AppContextHolder.getBean(MessageSendDao.class);
					MessageReceivedDao receivedDao = AppContextHolder.getBean(MessageReceivedDao.class);
					UserDao userDao = AppContextHolder.getBean(UserDao.class);

					MessageSend dbSend = sendDao.selectByPrimaryKey(sourceDynamicMsg.getMessageId());

					MessageSend updateSend = new MessageSend();
					updateSend.setMsgId(sourceDynamicMsg.getMessageId());
					updateSend.setPublishStatus(1);
					updateSend.setPublishTime(new Date());
					updateSend.setPublishCount(dbSend.getPublishCount() + 1);
					sendDao.updateByPrimaryKeySelective(updateSend);

					MessageReceived newReceive = new MessageReceived();
					newReceive.setMsgId(sourceDynamicMsg.getMessageId());
					newReceive.setPublishId(SeqFactory.getInstance().getSeqReceive());
					newReceive.setPubishTime(new Date());
					newReceive.setReceivedUserid(targetDynamicMsg.getUserId());
					newReceive.setSendUserid(sourceDynamicMsg.getUserId());
					newReceive.setSendNewReply(0);
					newReceive.setReceivedNewReply(0);
					newReceive.setReceivedStaus(0);

					receivedDao.insertSelective(newReceive);

					User user = userDao.selectByPrimaryKey(targetDynamicMsg.getUserId());

					PushServiceFactory.getDefaultService().pushMessageTip(user.getCid(), user.getUserId(), sourceDynamicMsg.getOriginalMsg());
				}
			});
		}
	}

	@Override
	public void onDynamicMsgMatchedStaticMsgs(final CachedMessage sourceDynamicMsg, List<CachedMessage> targetStaticMsgs, List<Double> scores) {
		for (int i = 0; i < targetStaticMsgs.size(); i++) {
			System.out.println(sourceDynamicMsg.getOriginalMsg() + " vs " + targetStaticMsgs.get(i).getOriginalMsg() + " score: " + scores.get(i));

			final CachedMessage targetStaticMsg = targetStaticMsgs.get(i);

			MessageContext.getInstance().getThreadPool().runInThread(new Thread() {

				@Override
				public void run() {

					MessageSendDao sendDao = AppContextHolder.getBean(MessageSendDao.class);
					MessageReceivedDao receivedDao = AppContextHolder.getBean(MessageReceivedDao.class);
					UserDao userDao = AppContextHolder.getBean(UserDao.class);

					MessageSend dbSend = sendDao.selectByPrimaryKey(sourceDynamicMsg.getMessageId());

					MessageSend updateSend = new MessageSend();
					updateSend.setMsgId(sourceDynamicMsg.getMessageId());
					updateSend.setPublishStatus(1);
					updateSend.setPublishTime(new Date());
					updateSend.setPublishCount(dbSend.getPublishCount() + 1);
					sendDao.updateByPrimaryKeySelective(updateSend);

					MessageReceived newReceive = new MessageReceived();
					newReceive.setMsgId(sourceDynamicMsg.getMessageId());
					newReceive.setPublishId(SeqFactory.getInstance().getSeqReceive());
					newReceive.setPubishTime(new Date());
					newReceive.setReceivedUserid(targetStaticMsg.getUserId());
					newReceive.setSendUserid(sourceDynamicMsg.getUserId());
					newReceive.setSendNewReply(0);
					newReceive.setReceivedNewReply(0);
					newReceive.setReceivedStaus(0);

					receivedDao.insertSelective(newReceive);

					User user = userDao.selectByPrimaryKey(targetStaticMsg.getUserId());

					PushServiceFactory.getDefaultService().pushMessageTip(user.getCid(), user.getUserId(), sourceDynamicMsg.getOriginalMsg());
				}
			});
		}
	}
}
