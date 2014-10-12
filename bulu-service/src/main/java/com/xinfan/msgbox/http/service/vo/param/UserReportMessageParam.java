package com.xinfan.msgbox.http.service.vo.param;

public class UserReportMessageParam extends BaseParam {
	private Long msgId;
	private String reportContext;
	private String context;
	private Integer reportType;
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public String getReportContext() {
		return reportContext;
	}
	public void setReportContext(String reportContext) {
		this.reportContext = reportContext;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Integer getReportType() {
		return reportType;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}
	
	
}
