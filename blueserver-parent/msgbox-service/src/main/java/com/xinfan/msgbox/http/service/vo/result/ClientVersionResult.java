package com.xinfan.msgbox.http.service.vo.result;

public class ClientVersionResult {
	  private Long id;

	    private String clientCode;

	    private String version;

	    private String isNewest;

	    private String incrDownloadUrl;

	    private String fullDownloadUrl;

	    private String introduceUrl;

	    private String remark;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getClientCode() {
			return clientCode;
		}

		public void setClientCode(String clientCode) {
			this.clientCode = clientCode;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getIsNewest() {
			return isNewest;
		}

		public void setIsNewest(String isNewest) {
			this.isNewest = isNewest;
		}

		public String getIncrDownloadUrl() {
			return incrDownloadUrl;
		}

		public void setIncrDownloadUrl(String incrDownloadUrl) {
			this.incrDownloadUrl = incrDownloadUrl;
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

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

	    
	    
}
