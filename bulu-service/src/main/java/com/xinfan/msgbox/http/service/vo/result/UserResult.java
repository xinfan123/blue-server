package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class UserResult extends BaseResult {
	private Long userId;

	private String userName;

	private String avatar;

	private String mobile;

	private Integer userState;

	private String passwd;

	private String regGpsy;

	private String regGpsx;

	private String regEarea;

	private Integer vip;

	private Date regTime;

	private Integer userCredit;

	private Integer userBalance;

	private Integer vipTatus;

	private Date vipRegTime;

	private Date vipEndTime;

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

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
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		this.passwd = passwd;
	}

	public String getRegGpsy() {
		return regGpsy;
	}

	public void setRegGpsy(String regGpsy) {
		this.regGpsy = regGpsy;
	}

	public String getRegGpsx() {
		return regGpsx;
	}

	public void setRegGpsx(String regGpsx) {
		this.regGpsx = regGpsx;
	}

	public String getRegEarea() {
		return regEarea;
	}

	public void setRegEarea(String regEarea) {
		this.regEarea = regEarea;
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

	public Integer getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(Integer userCredit) {
		this.userCredit = userCredit;
	}

	public Integer getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}

	public Integer getVipTatus() {
		return vipTatus;
	}

	public void setVipTatus(Integer vipTatus) {
		this.vipTatus = vipTatus;
	}

	public Date getVipRegTime() {
		return vipRegTime;
	}

	public void setVipRegTime(Date vipRegTime) {
		this.vipRegTime = vipRegTime;
	}

	public Date getVipEndTime() {
		return vipEndTime;
	}

	public void setVipEndTime(Date vipEndTime) {
		this.vipEndTime = vipEndTime;
	}

}
