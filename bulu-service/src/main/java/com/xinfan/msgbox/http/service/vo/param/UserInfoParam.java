package com.xinfan.msgbox.http.service.vo.param;

public class UserInfoParam extends BaseParam {
	private Long userId;
	
	private String mobile;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
