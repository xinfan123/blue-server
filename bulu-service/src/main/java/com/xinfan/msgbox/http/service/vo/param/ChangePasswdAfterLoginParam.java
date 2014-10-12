package com.xinfan.msgbox.http.service.vo.param;

public class ChangePasswdAfterLoginParam extends BaseParam {
	private String oldPasswd;
	private String newPasswd;
	
	public String getOldPasswd() {
		return oldPasswd;
	}
	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}
	public String getNewPasswd() {
		return newPasswd;
	}
	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
}
