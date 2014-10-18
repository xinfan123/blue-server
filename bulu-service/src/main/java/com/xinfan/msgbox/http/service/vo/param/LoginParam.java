package com.xinfan.msgbox.http.service.vo.param;

public class LoginParam extends BaseParam {
	private String mobile;
	private String passwd;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
