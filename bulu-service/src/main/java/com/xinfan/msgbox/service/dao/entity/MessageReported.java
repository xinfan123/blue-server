package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class MessageReported {
    private Long reportedId;

    private Long beReportedUserId;

    private Long beReportedMsgId;

    private String context;

    private Integer reportType;

    private Long reportUserId;

    private Date createTime;

    private Integer dealStatus;

    private String dealResult;

    public Long getReportedId() {
        return reportedId;
    }

    public void setReportedId(Long reportedId) {
        this.reportedId = reportedId;
    }

    public Long getBeReportedUserId() {
        return beReportedUserId;
    }

    public void setBeReportedUserId(Long beReportedUserId) {
        this.beReportedUserId = beReportedUserId;
    }

    public Long getBeReportedMsgId() {
        return beReportedMsgId;
    }

    public void setBeReportedMsgId(Long beReportedMsgId) {
        this.beReportedMsgId = beReportedMsgId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Long getReportUserId() {
        return reportUserId;
    }

    public void setReportUserId(Long reportUserId) {
        this.reportUserId = reportUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }
}