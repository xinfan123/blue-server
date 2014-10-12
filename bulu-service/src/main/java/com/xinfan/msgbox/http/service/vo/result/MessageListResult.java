package com.xinfan.msgbox.http.service.vo.result;

import java.util.List;

public class MessageListResult extends BaseResult{
	private List<MessageVO> list;

	public List<MessageVO> getList() {
		return list;
	}

	public void setList(List<MessageVO> list) {
		this.list = list;
	} 
    
}
