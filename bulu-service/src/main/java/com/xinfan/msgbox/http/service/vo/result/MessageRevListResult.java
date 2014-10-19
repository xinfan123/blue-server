package com.xinfan.msgbox.http.service.vo.result;

import java.util.ArrayList;
import java.util.List;

public class MessageRevListResult  extends BaseResult{

	public List<MessageRevSummaryVO> list = new ArrayList<MessageRevSummaryVO>();

	public List<MessageRevSummaryVO> getList() {
		return list;
	}

	public void setList(List<MessageRevSummaryVO> list) {
		this.list = list;
	}
	
	


}
