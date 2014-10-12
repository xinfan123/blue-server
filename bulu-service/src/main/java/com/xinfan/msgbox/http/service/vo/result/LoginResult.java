package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class LoginResult extends BaseResult {

	private Long userId;

	private String userName;

	private String mobile;

	private String regGpsy;

	private String regGpsx;

	private String regEarea;

	private Integer vip;

	private Date regTime;

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

}
