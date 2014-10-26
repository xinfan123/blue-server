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

	public List<Long> getSentMsgIds() {
		return sentMsgIds;
	}

	public void setSentMsgIds(List<Long> sentMsgIds) {
		this.sentMsgIds = sentMsgIds;
	}
}
