package com.xinfan.msgbox.http.service.vo.result;

public class ClientVersionResult  extends BaseResult{

	private String clientCode;

	private String clientName;

	private String currentVersion;

	private String fullDownloadUrl;

	private String introduceUrl;

	public String getCode() {
		return clientCode;
	}

	public void setCode(String code) {
		this.clientCode = code;
	}

	public String getName() {
		return clientName;
	}

	public void setName(String name) {
		this.clientName = name;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public String getFullDownloadUrl() {
		return fullDownloadUrl;
	}

	public void setFullDownloadUrl(String fullDownloadUrl) {
		this.fullDownloadUrl = fullDownloadUrl;
	}

	public String getIntroduceUrl() {
		return introduceUrl;
	}

	public void setIntroduceUrl(String introduceUrl) {
		this.introduceUrl = introduceUrl;
	}

}
