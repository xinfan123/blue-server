package com.xinfan.msgbox.config;

import java.util.HashMap;
import java.util.Map;

public class MessageCacheConfig implements Configable{
	private Map<String,Object> configMap = new HashMap<String, Object>();
	
	public MessageCacheConfig() {
		this.configMap.put("message.matched.listener", "com.xinfan.msgbox.service.listener.DefaultMessageMatchedListener");
		this.configMap.put("interest.processor.num", 1);
		this.configMap.put("messagepool.processor.num", 1);
		this.configMap.put("message.similarity.algorithm", "com.xinfan.msgbox.service.algorithm.SimpleSimilarityAlgorithm");
	}

	@Override
	public void setConfig(String key, Object value) {
		configMap.put(key, value);
	}

	@Override
	public Object getConfig(String key) {
		return configMap.get(key);
	}

}
