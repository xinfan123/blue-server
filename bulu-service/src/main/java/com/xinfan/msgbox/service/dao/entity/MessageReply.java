package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class MessageReply {
    private Long id;

    private Long msgId;

    private Long replyUserId;

    private Long beReplyedUserId;

    private String context;

    private Integer status;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Long getBeReplyedUserId() {
        return beReplyedUserId;
    }

    public void setBeReplyedUserId(Long beReplyedUserId) {
        this.beReplyedUserId = beReplyedUserId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}