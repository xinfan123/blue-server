package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class UserSent {
    private Long id;

	private Long userId;

	private String userSent;

	private String gpsy;

	private String gpsx;

	private String reginCode;

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

	public String getGpsy() {
		return gpsy;
	}

	public void setGpsy(String gpsy) {
		this.gpsy = gpsy == null ? null : gpsy.trim();
	}

	public String getGpsx() {
		return gpsx;
	}

	public void setGpsx(String gpsx) {
		this.gpsx = gpsx == null ? null : gpsx.trim();
	}

	public String getReginCode() {
		return reginCode;
	}

	public void setReginCode(String reginCode) {
		this.reginCode = reginCode == null ? null : reginCode.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}