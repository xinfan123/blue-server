package com.xinfan.msgbox.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 动态服务调用配置文件
 * 
 * @author Administrator
 * 
 */
public class ServiceMapConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMapConfig.class);

	private static String DEFAULT_CONFIG_PATH = "config/service.mapping.xml";

	private static ServiceMapConfig instance;

	private Map<String, ServiceMeta> classes = new HashMap<String, ServiceMeta>();

	private ServiceMapConfig() {

	}

	public static ServiceMapConfig getInstance() {

		if (instance == null) {
			init();
		}

		return instance;
	}

	private static synchronized void init() {
		try {
			ServiceMapBuilder builder = new ServiceMapBuilder(new ServiceMapConfig(), DEFAULT_CONFIG_PATH);
			builder.build();
			instance = builder.getServiceConfig();

		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	public Map<String, ServiceMeta> getClasses() {
		return classes;
	}

	public ServiceMeta getService(String id) {
		return classes.get(id);
	}

	public void setClasses(Map<String, ServiceMeta> classes) {
		this.classes = classes;
	}

	public void appendClasses(Map<String, ServiceMeta> classes) {
		this.classes.putAll(classes);
	}

}
