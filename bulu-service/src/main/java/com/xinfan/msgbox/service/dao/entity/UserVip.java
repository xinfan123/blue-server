package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class UserVip {
    private Long userId;

    private Integer vipTatus;

    private Date vipRegTime;

    private Date vipEndTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getVipTatus() {
        return vipTatus;
    }

    public void setVipTatus(Integer vipTatus) {
        this.vipTatus = vipTatus;
    }

    public Date getVipRegTime() {
        return vipRegTime;
    }

    public void setVipRegTime(Date vipRegTime) {
        this.vipRegTime = vipRegTime;
    }

    public Date getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(Date vipEndTime) {
        this.vipEndTime = vipEndTime;
    }
}