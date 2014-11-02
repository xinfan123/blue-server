package com.xinfan.msgbox.common;

public class Constants {
	
	/**
	 * session object key 
	 */
	public static final String SESSION_OBJECT_KEY = "UserSession";
	
	/**
	 * 处理成功
	 */
	public static final int JSON_SUCCESS = 0;
	
	/**
	 * 处理失败
	 */
	public static final int JSON_ERROR = -4;
	
	/**
	 * 需要登录
	 */
	public static final int JSON_LOGIN = -1;
	
	/**
	 * 无权限
	 */
	public static final int JSON_FORBIDDEN = -2;
	
	/**
	 * 并发上限
	 */
	public static final int JSON_CONCURRENT = -3;
	
	/**
	 * 请求往上级部门转发
	 */
	public static final int JSON_GOSUPERIOR = -5;
	
	public static final String INTERCEPT_CHECK = "check";
	public static final String INTERCEPT_BEFOREINVOKE = "beforeInvoke";
	public static final String INTERCEPT_AFTERINVOKE = "afterInvoke";
	

	
}
