package com.xinfan.msgbox.vo;

import java.util.LinkedList;
import java.util.List;

import com.xinfan.msgbox.service.dao.entity.User;

public class CachedUser {
	private long userId;
	private User user;
	private UserProfile profile;
	private List<Long> interestsMsgIds = new LinkedList<Long>();
	private List<Long> sentMsgIds = new LinkedList<Long>();
	
	public CachedUser(User user,UserProfile profile) {
		this.user = user;
		this.profile = profile;
		this.userId = user.getUserId();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	public List<Long> getInterestsMsgIds() {
		return interestsMsgIds;
	}

	public void setInterestsMsgIds(List<Long> interestsMsgIds) {
		this.interestsMsgIds = interestsMsgIds;
	}
	
	public void addInterestsMsg(CachedMessage message)
	{
		this.interestsMsgIds.add(message.getMessageId());
	}
	public void removeInterestsMsg(CachedMessage message)
	{
		removeFromList(interestsMsgIds, message.getMessageId());
	}

	public List<Long> getSentMsgIds() {
		return sentMsgIds;
	}

	public void setSentMsgIds(List<Long> sentMsgIds) {
		this.sentMsgIds = sentMsgIds;
	}
	
	public void addSentMsg(CachedMessage message)
	{
		this.sentMsgIds.add(message.getMessageId());
	}
	public void removeSentMsg(CachedMessage message)
	{
		removeFromList(sentMsgIds, message.getMessageId());
	}
	
	private void removeFromList(List<Long> list,long id)
	{
		if(null == list) return;
		for(int i=0;i<list.size();i++)
		{
			if(id == list.get(i))
			{
				list.remove(i);
			}
		}
	}
}
