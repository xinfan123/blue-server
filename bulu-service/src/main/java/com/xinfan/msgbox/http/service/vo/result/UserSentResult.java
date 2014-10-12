package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class UserSentResult {
	 private Long id;

	    private Long userId;

	    private String userSent;

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

	    public String getUserSent() {
	        return userSent;
	    }

	    public void setUserSent(String userSent) {
	        this.userSent = userSent == null ? null : userSent.trim();
	    }

	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }
}
