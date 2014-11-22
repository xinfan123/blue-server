package com.xinfan.msgbox.http.service.vo.param;

public class RevMessageReadParam extends BaseParam {

	private Long msgId;

	private Long publishId;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}
