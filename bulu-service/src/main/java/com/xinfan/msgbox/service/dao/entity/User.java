package com.xinfan.msgbox.service.dao.entity;

import java.util.Date;

public class User {
	private Long userId;

	private String userName;

	private String mobile;

	private Integer userState;

	private String passwd;

	private String regGpsy;

	private String regGpsx;

	private String regEarea;

	private Integer vip;

	private Date regTime;

	private String cid;

	private Date cidTime;

	private Date loginTime;

	private Integer online;

	private String avatar;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd == null ? null : passwd.trim();
	}

	public String getRegGpsy() {
		return regGpsy;
	}

	public void setRegGpsy(String regGpsy) {
		this.regGpsy = regGpsy == null ? null : regGpsy.trim();
	}

	public String getRegGpsx() {
		return regGpsx;
	}

	public void setRegGpsx(String regGpsx) {
		this.regGpsx = regGpsx == null ? null : regGpsx.trim();
	}

	public String getRegEarea() {
		return regEarea;
	}

	public void setRegEarea(String regEarea) {
		this.regEarea = regEarea == null ? null : regEarea.trim();
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid == null ? null : cid.trim();
	}

	public Date getCidTime() {
		return cidTime;
	}

	public void setCidTime(Date cidTime) {
		this.cidTime = cidTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}
}