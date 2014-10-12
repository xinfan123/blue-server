package com.xinfan.msgbox.http.service.vo.result;

import java.util.List;

/**
 * 用户基本信息
 * @author Administrator
 *
 */
public class UserSentListResult extends BaseResult{
	private List<UserSentResult> list;

	public List<UserSentResult> getList() {
		return list;
	}

	public void setList(List<UserSentResult> list) {
		this.list = list;
	} 
    
    
    
}
