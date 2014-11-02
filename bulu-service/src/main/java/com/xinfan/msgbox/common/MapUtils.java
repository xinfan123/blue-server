package com.xinfan.msgbox.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * BEAN处理帮助类
 * 
 * @author cyp
 * 
 */
public class MapUtils {
	public static final String CHECK_OK = "OK";
	private static final Logger logger = LoggerFactory.getLogger(MapUtils.class);

	/**
	 * 将pojo对象属性转换成map
	 * 
	 * @param bean
	 * @return
	 */
	public static Map toMap(Object bean) {
		try {
			return BeanUtils.describe(bean);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 简单的将map转为bean
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map<String, Object> map, Class<T> clazz) {
		System.out.println(map);
		if (null == clazz) {
			return null;
		}
		if (null == map) {
			return null;
		}
		T bean = null;
		try {
			bean = clazz.newInstance();
			for (String key : map.keySet()) {
				Class type = PropertyUtils.getPropertyType(bean, key);
				Object value = map.get(key);
				if (type != null && !"class".equals(key) && value != null && !"null".equalsIgnoreCase(String.valueOf(value))) {
					try {
						// 设置参数
						PropertyUtils.setProperty(bean, key, ConvertUtils.convert(value, type));
					} catch (Exception e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return bean;
	}

}
