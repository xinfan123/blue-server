package com.xinfan.msgbox.http.excute.mapper;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

/**
 * 
 * 文件配置管理
 * 
 * @author cyp
 * 
 */
public class WsFileConfig {

	public static WsFileConfig instaince;

	private Properties prop;

	public static WsFileConfig getInstance() {
		try {
			if (instaince == null) {
				instaince = new WsFileConfig();
				instaince.prop = new Properties();
				ClassPathResource loader = new ClassPathResource("/config/application.properties");
				instaince.prop.load(loader.getInputStream());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return instaince;
	}

	public String getString(String name) {
		String value = prop.getProperty(name);
		return value != null ? value.trim() : null;
	}

	public String getString(String name, String defaultValue) {
		return prop.getProperty(name, defaultValue).trim();
	}

	public int getInt(String name) {
		return Integer.parseInt(getString(name));
	}

	public static void main(String[] args) {
		String configId = WsFileConfig.getInstance().getString("configId");
		System.out.println(configId);
	}

	public Properties getProp() {
		return prop;
	}
}
