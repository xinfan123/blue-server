package com.xinfan.msgbox.http.service.vo.result;

import java.util.Date;

public class ConfigResult {
	  	private String configKey;

	    private String configValue;

	    private String remark;

	    private Date createTime;
	    
	    public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public String getConfigKey() {
	        return configKey;
	    }

	    public void setConfigKey(String configKey) {
	        this.configKey = configKey == null ? null : configKey.trim();
	    }

	    public String getConfigValue() {
	        return configValue;
	    }

	    public void setConfigValue(String configValue) {
	        this.configValue = configValue == null ? null : configValue.trim();
	    }
}
