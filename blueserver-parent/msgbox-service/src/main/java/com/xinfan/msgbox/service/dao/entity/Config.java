package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class Config extends ConfigKey {
    private String remark;

    private Date createTime;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}