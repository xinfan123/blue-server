package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class MessageReceived {
    private Long publishId;

    private Long msgId;

    private Long receivedUserid;

    private Long sendUserid;

    private Integer sendNewReply;

    private Integer receivedNewReply;

    private Integer receivedStaus;

    private Date readTime;

    private Date deleteTime;

    private Date pubishTime;

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getReceivedUserid() {
        return receivedUserid;
    }

    public void setReceivedUserid(Long receivedUserid) {
        this.receivedUserid = receivedUserid;
    }

    public Long getSendUserid() {
        return sendUserid;
    }

    public void setSendUserid(Long sendUserid) {
        this.sendUserid = sendUserid;
    }

    public Integer getSendNewReply() {
        return sendNewReply;
    }

    public void setSendNewReply(Integer sendNewReply) {
        this.sendNewReply = sendNewReply;
    }

    public Integer getReceivedNewReply() {
        return receivedNewReply;
    }

    public void setReceivedNewReply(Integer receivedNewReply) {
        this.receivedNewReply = receivedNewReply;
    }

    public Integer getReceivedStaus() {
        return receivedStaus;
    }

    public void setReceivedStaus(Integer receivedStaus) {
        this.receivedStaus = receivedStaus;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getPubishTime() {
        return pubishTime;
    }

    public void setPubishTime(Date pubishTime) {
        this.pubishTime = pubishTime;
    }
}