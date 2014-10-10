package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class UserLinkmanResult {
    private Long userId;

    private Long linkUserId;
    
    private String linkRemark;

    private Date createTime;
    
    private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLinkUserId() {
		return linkUserId;
	}

	public void setLinkUserId(Long linkUserId) {
		this.linkUserId = linkUserId;
	}

	public String getLinkRemark() {
		return linkRemark;
	}

	public void setLinkRemark(String linkRemark) {
		this.linkRemark = linkRemark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
