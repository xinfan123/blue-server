package com.xinfan.msgbox.http.service.vo.result;

import java.util.ArrayList;
import java.util.List;

public class MessageSendListResult extends BaseResult {

	public List<MessageSendSummaryVO> list = new ArrayList<MessageSendSummaryVO>();

	public List<MessageSendSummaryVO> getList() {
		return list;
	}

	public void setList(List<MessageSendSummaryVO> list) {
		this.list = list;
	}

}
