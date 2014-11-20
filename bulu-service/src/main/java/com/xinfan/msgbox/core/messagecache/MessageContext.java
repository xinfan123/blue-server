package com.xinfan.msgbox.core.messagecache;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.core.algorithm.SimHashAlgorithm;
import com.xinfan.msgbox.core.algorithm.SimilarityAlgorithm;
import com.xinfan.msgbox.core.deamon.MessageCacheDeamon;
import com.xinfan.msgbox.core.deamon.UserCacheDeamon;
import com.xinfan.msgbox.core.listener.DefaultMessageMatchedListener;
import com.xinfan.msgbox.core.listener.MessageMatchedListener;
import com.xinfan.msgbox.core.processor.StaticMessageProcessor;
import com.xinfan.msgbox.core.listener.SimpleThreadPool;
import com.xinfan.msgbox.core.listener.ThreadPool;
import com.xinfan.msgbox.core.processor.MessageProcessor;
import com.xinfan.msgbox.core.processor.DynamicMessageProcessor;
import com.xinfan.msgbox.core.user.MemoryUserCache;
import com.xinfan.msgbox.core.user.UserCache;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.CachedUser;
import com.xinfan.msgbox.core.vo.Position;
import com.xinfan.msgbox.core.vo.UserProfile;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserSet;

public class MessageContext implements MessageCenterFacade {
	private static MessageContext instance;

	private UserCache userCache;// 用户缓存

	private MessageCache interestsCache;// 感兴趣的消息缓存

	private MessageCache messagePool;// 发送的消息缓存

	private MessageMatchedListener messageMatchedListener = new DefaultMessageMatchedListener();

	private ThreadPool threadPool;
	private int threadCount = 10;

	private SimilarityAlgorithm algorithm = new SimHashAlgorithm();

	private int interestProcessorNum = 1;
	private int messagePoolProcessorNum = 1;

	private List<MessageProcessor> interestsProcessors = new LinkedList<MessageProcessor>();
	private List<MessageProcessor> messagePoolProcessors = new LinkedList<MessageProcessor>();

	public SimilarityAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(SimilarityAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public int getInterestProcessorNum() {
		return interestProcessorNum;
	}

	public void setInterestProcessorNum(int interestProcessorNum) {
		this.interestProcessorNum = interestProcessorNum;
	}

	public int getMessagePoolProcessorNum() {
		return messagePoolProcessorNum;
	}

	public void setMessagePoolProcessorNum(int messagePoolProcessorNum) {
		this.messagePoolProcessorNum = messagePoolProcessorNum;
	}

	public MessageMatchedListener getMessageMatchedListener() {
		return messageMatchedListener;
	}

	public void setMessageMatchedListener(MessageMatchedListener messageMatchedListener) {
		this.messageMatchedListener = messageMatchedListener;
	}

	private MessageContext() {
		init();
	}

	public ThreadPool getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(ThreadPool threadPool) {
		this.threadPool = threadPool;
	}

	private void init() {
		interestsCache = new MemoryMessageCache();
		interestsCache.addMessageFilter(new AreaFilter());
		interestsCache.addMessageFilter(new DistanceFilter());
		//
		messagePool = new MemoryMessageCache();
		messagePool.addMessageFilter(new AreaFilter());
		messagePool.addMessageFilter(new DistanceFilter());
		// 初始化所有用户
		userCache = new MemoryUserCache(this);

		interestsCache.addMessageFilter(new UserFilter(userCache));
		messagePool.addMessageFilter(new UserFilter(userCache));

		threadPool = new SimpleThreadPool(threadCount, 5);
		threadPool.initialize();
	}

	private void setUp() {

		for (int i = 0; i < interestProcessorNum; i++) {
			interestsProcessors.add(new StaticMessageProcessor(messagePool, interestsCache, messageMatchedListener, algorithm));
		}
		for(int i=0;i<messagePoolProcessorNum;i++)
		{
			messagePoolProcessors.add(new DynamicMessageProcessor(messagePool,interestsCache, messageMatchedListener, algorithm));
		}

	}

	public void start() {
		setUp();
		// interestsCache.start();
		new MessageCacheDeamon(messagePool).start();
		new UserCacheDeamon(userCache).start();

		for (int i = 0; i < interestProcessorNum; i++) {
			interestsProcessors.get(i).start();
		}
		for (int i = 0; i < messagePoolProcessorNum; i++) {
			messagePoolProcessors.get(i).start();
		}
	}

	public void shutdown() {
		if (threadPool != null) {
			threadPool.shutdown(true);
		}
	}

	public synchronized static MessageContext getInstance() {
		if (null == instance) {
			instance = new MessageContext();
		}
		return instance;
	}

	public MessageCache getInterestsCache() {
		return interestsCache;
	}

	public MessageCache getMessagePool() {
		return messagePool;
	}

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	@Override
	public boolean addUser(User user, UserSet userSet) {
		UserProfile profile = new UserProfile(userSet);
		CachedUser cuser = new CachedUser(user, profile);
		userCache.addUser(cuser);
		return false;
	}

	@Override
	public boolean updateUserProfile(long userId, UserSet userSet) {
		User user = new User();
		user.setUserId(userId);
		UserProfile profile = new UserProfile(userSet);
		CachedUser cuser = new CachedUser(user, profile);
		return userCache.updateUserProfile(cuser);
	}

	@Override
	public boolean updateUserPosition(long userId, Position position) {
		return userCache.updateUserPosition(userId, position);
	}

	@Override
	public boolean addUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.addUserInterestsMsg(userId, cmessage);
	}

	@Override
	public boolean updateUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.updateUserInterestsMsg(userId, cmessage);
	}

	@Override
	public boolean deleteUserInterestMsg(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.deleteUserInterestsMsg(userId, cmessage);
	}

	@Override
	public boolean sendMessage(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.sendMessage(cmessage);
	}

	@Override
	public boolean updateMessage(long userId, Message message) {

		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.updateMessage(cmessage);
	}

	@Override
	public boolean deleteMessage(long userId, Message message) {
		CachedMessage cmessage = constructCachedMsg(userId, message);
		return userCache.deleteMessage(cmessage);
	}

	@Override
	public boolean updateMessageValideTime(long userId, long messageId, Date deadTime) {
		// CachedMessage cmessage = new CachedMessage();
		// cmessage.setUserId(userId);
		// cmessage.setMessageId(messageId);
		// return userCache.updateMessageValideTime(userId,messageId,deadTime);
		CachedMessage old = messagePool.getMessageById(messageId);
		CachedMessage newMsg;
		try {
			newMsg = (CachedMessage) old.clone();
			newMsg.setDeadTime(deadTime);
			return messagePool.updateMessage(old, newMsg);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private CachedMessage constructCachedMsg(long userId, Message message) {
		CachedMessage cmessage = new CachedMessage();
		cmessage.setUserId(userId);
		cmessage.setMessageId(message.getMsgId());
		cmessage.setOriginalMsg(message.getTitle());
		cmessage.setSrcPosition(new Position(message.getGpsx(), message.getGpsy(), message.getReginCode()));
		cmessage.setDeadTime(message.getValidTime() == null ? new Date(System.currentTimeMillis() + 20 * 60 * 1000) : message.getValidTime());
		return cmessage;
	}

	@Override
	public boolean deleteUser(User user) {
		return userCache.deleteUser(user.getUserId());
	}
}
