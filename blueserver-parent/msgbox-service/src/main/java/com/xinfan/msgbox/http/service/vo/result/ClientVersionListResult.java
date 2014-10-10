package com.xinfan.msgbox.http.service.vo.result;

import java.util.List;

public class ClientVersionListResult extends BaseResult{
	private List<ClientVersionResult> list;

	public List<ClientVersionResult> getList() {
		return list;
	}

	public void setList(List<ClientVersionResult> list) {
		this.list = list;
	}
	
} 
