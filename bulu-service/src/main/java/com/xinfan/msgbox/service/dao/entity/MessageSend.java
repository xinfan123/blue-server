package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class MessageSend {
    private Long msgId;

    private Long sendUserId;

    private Integer publishStatus;

    private Date publishTime;

    private Integer publishCount;

    private Integer readCount;

    private Integer publishType;

    private Date sendTime;

    private Integer sendCurrentCredit;

    private Integer newReplyForSend;

    private Integer msgStatus;

    private String publishTo;

    private Date createTime;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getPublishType() {
        return publishType;
    }

    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendCurrentCredit() {
        return sendCurrentCredit;
    }

    public void setSendCurrentCredit(Integer sendCurrentCredit) {
        this.sendCurrentCredit = sendCurrentCredit;
    }

    public Integer getNewReplyForSend() {
        return newReplyForSend;
    }

    public void setNewReplyForSend(Integer newReplyForSend) {
        this.newReplyForSend = newReplyForSend;
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getPublishTo() {
        return publishTo;
    }

    public void setPublishTo(String publishTo) {
        this.publishTo = publishTo == null ? null : publishTo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}