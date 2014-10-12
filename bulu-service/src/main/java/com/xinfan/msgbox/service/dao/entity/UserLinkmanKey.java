package com.xinfan.msgbox.service.dao.entity;

public class UserLinkmanKey {
    private Long userId;

    private Long linkUserId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLinkUserId() {
        return linkUserId;
    }

    public void setLinkUserId(Long linkUserId) {
        this.linkUserId = linkUserId;
    }
}