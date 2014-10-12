package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class UserSet {
    private Long userId;

    private Integer newMsgNotify;

    private Integer voice;

    private Integer vibrate;

    private Integer maxCount;

    private Integer similarLevel;

    private Integer minAmmount;

    private Integer minCredit;

    private Date updatetime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNewMsgNotify() {
        return newMsgNotify;
    }

    public void setNewMsgNotify(Integer newMsgNotify) {
        this.newMsgNotify = newMsgNotify;
    }

    public Integer getVoice() {
        return voice;
    }

    public void setVoice(Integer voice) {
        this.voice = voice;
    }

    public Integer getVibrate() {
        return vibrate;
    }

    public void setVibrate(Integer vibrate) {
        this.vibrate = vibrate;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public Integer getSimilarLevel() {
        return similarLevel;
    }

    public void setSimilarLevel(Integer similarLevel) {
        this.similarLevel = similarLevel;
    }

    public Integer getMinAmmount() {
        return minAmmount;
    }

    public void setMinAmmount(Integer minAmmount) {
        this.minAmmount = minAmmount;
    }

    public Integer getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(Integer minCredit) {
        this.minCredit = minCredit;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}