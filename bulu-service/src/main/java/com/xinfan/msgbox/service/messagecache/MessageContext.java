package com.xinfan.msgbox.service.messagecache;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.service.algorithm.SimpleSimilarityAlgorithm;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.listener.DefaultMessageMatchedListener;
import com.xinfan.msgbox.service.listener.MessageMatchedListener;
import com.xinfan.msgbox.service.processor.InterestsMessageProcessor;
import com.xinfan.msgbox.service.processor.MessageProcessor;
import com.xinfan.msgbox.service.processor.SentMessageProcessor;
import com.xinfan.msgbox.service.user.SimpleUserCacheCenter;
import com.xinfan.msgbox.service.user.UserCacheCenter;
import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.CachedUser;
import com.xinfan.msgbox.vo.Position;
import com.xinfan.msgbox.vo.UserProfile;

public class MessageContext implements MessageCenterFacade{
	private static MessageContext instance;
	
	private UserCacheCenter userCache;//用户缓存
	
	private InterestsMsgCacheCenter interestsCache;//感兴趣的消息缓存
	
	private SentMsgCacheCenter messagePool;//发送的消息缓存
	
	private MessageMatchedListener messageMatchedListener = new DefaultMessageMatchedListener();
	
	private SimpleSimilarityAlgorithm algorithm = new SimpleSimilarityAlgorithm();
	
	private int interestProcessorNum = 1;
	private int messagePoolProcessorNum = 1;
	
	private List<MessageProcessor> interestsProcessors = new LinkedList<MessageProcessor>();
	private List<MessageProcessor> messagePoolProcessors = new LinkedList<MessageProcessor>();
	
	public SimpleSimilarityAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(SimpleSimilarityAlgorithm algorithm) {
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

	public void setMessageMatchedListener(
			MessageMatchedListener messageMatchedListener) {
		this.messageMatchedListener = messageMatchedListener;
	}
	
	private MessageContext()
	{
		init();
	}
	
	private void init(){
		interestsCache = new InterestsMsgCacheCenter();
		
		messagePool = new SentMsgCacheCenter();
		
		//初始化所有用户
		userCache = new SimpleUserCacheCenter(this);

	}
	
	private void setUp()
	{

		for(int i=0;i<interestProcessorNum;i++)
		{
			interestsProcessors.add(new InterestsMessageProcessor(interestsCache, messagePool, messageMatchedListener, algorithm));
		}
		for(int i=0;i<messagePoolProcessorNum;i++)
		{
			messagePoolProcessors.add(new SentMessageProcessor(messagePool,interestsCache, messageMatchedListener, algorithm));
		}

	}
	
	public void start()
	{
		setUp();

		interestsCache.start();
		messagePool.start();
		for(MessageProcessor p:interestsProcessors)
		{
			p.start();
		}
		for(MessageProcessor p:messagePoolProcessors)
		{
			p.start();
		}
	}
	
	public synchronized static MessageContext getInstance()
	{
		if(null == instance)
		{
			instance = new MessageContext();
		}
		return instance;
	}

	public InterestsMsgCacheCenter getInterestsCache() {
		return interestsCache;
	}

	public SentMsgCacheCenter getMessagePool() {
		return messagePool;
	}

	public UserCacheCenter getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCacheCenter userCache) {
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
		return userCache.deleteUserInterestsMsg(userId,cmessage);
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
	public boolean updateMessageValideTime(long userId, long messageId,
			Date deadTime) {
		CachedMessage cmessage = new CachedMessage();
		cmessage.setUserId(userId);
		cmessage.setMessageId(messageId);
		return userCache.updateMessageValideTime(userId,messageId,deadTime);
	}
	
	private CachedMessage constructCachedMsg(long userId, Message message) {
		CachedMessage cmessage = new CachedMessage();
		cmessage.setUserId(userId);
		cmessage.setMessageId(message.getMsgId());
		cmessage.setOriginalMsg(message.getTitle());
		cmessage.setSrcPosition(new Position(message.getGpsx(),message.getGpsy()));
		cmessage.setDeadTime(message.getValidTime());
		return cmessage;
	}
}
