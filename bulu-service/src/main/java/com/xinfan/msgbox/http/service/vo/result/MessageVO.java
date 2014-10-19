package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class MessageVO {
	private Long msgId;

	private String title;

	private String context;

	private Date validTime;

	private Integer durationTime;

	private Integer sendType;

	private String sendArea;

	private String sendDistance;

	private Integer amountStatus;

	private Long amount;

	private Integer msgStatus;

	private Long createUserId;

	private String gpsy;

	private String gpsx;

	private String reginCode;

	private Date createTime;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Integer getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(Integer durationTime) {
		this.durationTime = durationTime;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public String getSendArea() {
		return sendArea;
	}

	public void setSendArea(String sendArea) {
		this.sendArea = sendArea == null ? null : sendArea.trim();
	}

	public String getSendDistance() {
		return sendDistance;
	}

	public void setSendDistance(String sendDistance) {
		this.sendDistance = sendDistance == null ? null : sendDistance.trim();
	}

	public Integer getAmountStatus() {
		return amountStatus;
	}

	public void setAmountStatus(Integer amountStatus) {
		this.amountStatus = amountStatus;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getGpsy() {
		return gpsy;
	}

	public void setGpsy(String gpsy) {
		this.gpsy = gpsy == null ? null : gpsy.trim();
	}

	public String getGpsx() {
		return gpsx;
	}

	public void setGpsx(String gpsx) {
		this.gpsx = gpsx == null ? null : gpsx.trim();
	}

	public String getReginCode() {
		return reginCode;
	}

	public void setReginCode(String reginCode) {
		this.reginCode = reginCode == null ? null : reginCode.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
