package com.xinfan.msgbox.http.service.vo.param;

public class ClientVersionParam extends BaseParam{
	
	private String clientCode;
	private String currentVersion;

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
}
