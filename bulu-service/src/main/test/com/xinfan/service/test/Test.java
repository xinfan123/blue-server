package com.xinfan.service.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;

public class Test {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		BaseParam param = new BaseParam();

		Map<String, Object> map = PropertyUtils.describe(param);

		System.out.println(map);
	}

}
