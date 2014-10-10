package com.xinfan.msgbox.cache;


public abstract class CacheLoader {
	
	
	private String cacheKey;
	
	private CacheProvider cacheProvier;
	
	private Integer order;
	
	private String cacheName;
	
	private String description;
	
	private boolean loadOnStartUp;

	public CacheProvider getCacheProvier() {
		return cacheProvier;
	}

	public void setCacheProvier(CacheProvider cacheProvier) {
		this.cacheProvier = cacheProvier;
	}

	public abstract boolean load();

	public abstract boolean refresh();

	public String getCacheKey() {
		return this.cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isLoadOnStartUp() {
		return loadOnStartUp;
	}

	public void setLoadOnStartUp(boolean loadOnStartUp) {
		this.loadOnStartUp = loadOnStartUp;
	}
	
	
	
	

}
