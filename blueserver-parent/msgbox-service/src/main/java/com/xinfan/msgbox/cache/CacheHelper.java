package com.xinfan.msgbox.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.xinfan.msgbox.http.context.AppContextHolder;

public class CacheHelper {

	private static CacheHelper instance;

	private static Object lock = new Object();

	
	private static final Map<String, CacheLoader> loaderMap = Collections.synchronizedMap(new HashMap());
	
	
	public static CacheHelper getInstance(){
		if (instance == null) {
			synchronized (lock) {
				instance = new CacheHelper();
				instance.initLoaderMapByXml();
			}
		}
		return instance;
	}
	
	public void putCacheLoaderToLoadMap(String cachekey, CacheLoader loader){
		loaderMap.put(cachekey, loader);
	}
	
	public static Map<String, CacheLoader> getLoaderMap(){
		return loaderMap;
	}

	//初始化loaderMap  
	private void initLoaderMapByXml() {
		//xml方式 
		Map<String, CacheLoader> loaders = AppContextHolder.getBeansOfType(CacheLoader.class);
		if (loaders != null) {
			for(String key : loaders.keySet()){
				CacheLoader value = loaders.get(key);
				if(loaderMap.get(value.getCacheKey()) != null){
					throw new RuntimeException("配置文件中，key值为："+value.getCacheKey()+"的缓存配置项重复，请检查!!!");
				}
				loaderMap.put(value.getCacheKey(), value);
			}
		}
	}

	/**
	 * 根据缓存key获取属性值
	 * @param key
	 * @return
	 */
	public static Object getCacheObject(String key) {
		if (instance == null) {
			synchronized (lock) {
				instance = new CacheHelper();
			}
		}
		
		CacheLoader loader = loaderMap.get(key);
		if(loader == null){
			throw new IllegalArgumentException("key " + key + " 对应缓存加载器为空，请确认代码使用是否正确");
		}
		
		

		CacheProvider provider = loader.getCacheProvier();
		Object obj = provider.getAttribute(key);
		
		//缓存中不存在值时，会重新加载
		if (obj == null) {
			synchronized (lock) {
				loader.load();
			}

			obj = provider.getAttribute(key);
		}

		return obj;
	}

	/**
	 * 根据key值刷新缓存
	 * @param key
	 * @return
	 */
	public static boolean refresh(String key) {

		CacheLoader loader = loaderMap.get(key);
		if (loader != null) {
			synchronized (lock) {
				return loader.refresh();
			}
		}

		return false;
	}

}
