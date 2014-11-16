package com.xinfan.msgbox.core.vo;

import com.xinfan.msgbox.service.dao.entity.UserSet;

public class UserProfile {
	private int maxReceiveCount = 3;
	private int similarLevel = 3;
	public UserProfile(UserSet userSet) {
		this.maxReceiveCount = userSet.getMaxCount();
		this.similarLevel = userSet.getSimilarLevel();
	}
	public int getMaxReceiveCount() {
		return maxReceiveCount;
	}
	public void setMaxReceiveCount(int maxReceiveCount) {
		this.maxReceiveCount = maxReceiveCount;
	}
	public int getSimilarLevel() {
		return similarLevel;
	}
	public void setSimilarLevel(int similarLevel) {
		this.similarLevel = similarLevel;
	}
	
}
