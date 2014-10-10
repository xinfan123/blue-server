package com.xinfan.msgbox.http.service.vo.param;

public class UserLinkmanParam extends BaseParam {
    private Long userId;

    private Long linkUserId;
    
    private String linkRemark;

	public String getLinkRemark() {
		return linkRemark;
	}

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

	public void setLinkRemark(String linkRemark) {
		this.linkRemark = linkRemark;
	}
    
}
