package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class UserKey {
    private Long id;

    private Long userId;

    private Integer keyLevel;

    private String keyName;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getKeyLevel() {
        return keyLevel;
    }

    public void setKeyLevel(Integer keyLevel) {
        this.keyLevel = keyLevel;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}