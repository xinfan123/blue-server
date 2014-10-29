package com.xinfan.msgbox.config;

public interface Configable {
	void setConfig(String key,Object value);
	Object getConfig(String key);
}
