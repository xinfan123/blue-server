package com.xinfan.msgbox.http.service.vo.param;

import java.util.Date;

public class SendMessageParam extends BaseParam {
	// 推送类型
	private Integer publishType;
	// 点对点或行业推送的id
	private String publishTo;

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

	public Integer getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(Integer durationTime) {
		this.durationTime = durationTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
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
		this.sendArea = sendArea;
	}

	public String getSendDistance() {
		return sendDistance;
	}

	public void setSendDistance(String sendDistance) {
		this.sendDistance = sendDistance;
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
		this.gpsy = gpsy;
	}

	public String getGpsx() {
		return gpsx;
	}

	public void setGpsx(String gpsx) {
		this.gpsx = gpsx;
	}

	public String getReginCode() {
		return reginCode;
	}

	public void setReginCode(String reginCode) {
		this.reginCode = reginCode;
	}

	public Integer getPublishType() {
		return publishType;
	}

	public void setPublishType(Integer publishType) {
		this.publishType = publishType;
	}

	public String getPublishTo() {
		return publishTo;
	}

	public void setPublishTo(String publishTo) {
		this.publishTo = publishTo;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}
