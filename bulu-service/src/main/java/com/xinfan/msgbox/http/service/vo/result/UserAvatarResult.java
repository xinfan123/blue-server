package com.xinfan.msgbox.http.service.vo.result;



public class UserAvatarResult extends BaseResult {
	private Long userId;

	private String avatar;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
