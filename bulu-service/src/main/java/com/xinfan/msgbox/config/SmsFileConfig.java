package com.xinfan.msgbox.config;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

/**
 * 
 * 文件配置管理
 * 
 * @author cyp
 *
 */
public class SmsFileConfig {
	
	private static SmsFileConfig instance;
	
	private Properties prop;
	
	public static SmsFileConfig getInstance() {
		try {
			if (instance == null) {
				instance = new SmsFileConfig();
				instance.prop = new Properties();
				ClassPathResource loader = new ClassPathResource(
						"/config/sms.properties");
				instance.prop.load(loader.getInputStream());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return instance;
	}
	
	public String getString(String name){
		return prop.getProperty(name);
	}
	
	public String getString(String name, String defaultValue) {
		return prop.getProperty(name, defaultValue);
	}
	
	public long getLong(String name) {
		return Long.parseLong(getString(name));
	}
	
	public static void main(String[] args){
		String configId = SmsFileConfig.getInstance().getString("yunpian_sms_apikey");
		System.out.println(configId);
	}

	public Properties getProp() {
		return prop;
	}
}
