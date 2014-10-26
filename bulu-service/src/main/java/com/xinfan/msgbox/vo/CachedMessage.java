package com.xinfan.msgbox.vo;

import java.util.Date;

public class CachedMessage {
	private String originalMsg;
	private long userId;
	private long messageId;
	private Position srcPosition;
	private Position targetPosition;
	private Date deadTime;
	
	private int matchType;//消息的匹配类型，按类型匹配，减少不必要的匹配
	
	public String getOriginalMsg() {
		return originalMsg;
	}
	public void setOriginalMsg(String originalMsg) {
		this.originalMsg = originalMsg;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public Position getSrcPosition() {
		return srcPosition;
	}
	public void setSrcPosition(Position srcPosition) {
		this.srcPosition = srcPosition;
	}
	public Position getTargetPosition() {
		return targetPosition;
	}
	public void setTargetPosition(Position targetPosition) {
		this.targetPosition = targetPosition;
	}
	public Date getDeadTime() {
		return deadTime;
	}
	public void setDeadTime(Date deadTime) {
		this.deadTime = deadTime;
	}
	public int getMatchType() {
		return matchType;
	}
	public void setMatchType(int matchType) {
		this.matchType = matchType;
	}

}
