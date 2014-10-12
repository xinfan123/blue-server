package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class UserLinkman extends UserLinkmanKey {
    private String linkRemark;

    private Date createTime;

    public String getLinkRemark() {
        return linkRemark;
    }

    public void setLinkRemark(String linkRemark) {
        this.linkRemark = linkRemark == null ? null : linkRemark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}