package com.xinfan.msgbox.http.service.vo.param;

import java.io.Serializable;


public class BaseParam implements Serializable{
	private String funId;
	
	private Long userId;
	
	public String getFunId() {
		return funId;
	}
	public void setFunId(String funId) {
		this.funId = funId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
