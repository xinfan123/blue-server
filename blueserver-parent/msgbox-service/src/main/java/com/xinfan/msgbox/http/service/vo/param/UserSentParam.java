package com.xinfan.msgbox.http.service.vo.param;

public class UserSentParam extends BaseParam {
    private Long id;
    
    private Long userId;

    private String userSent;

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
		this.userSent = userSent;
	}
    
}
