package com.xinfan.msgbox.config;


/**
 * 服务调用元数据
 * @author cyp
 */
public class ServiceMeta {
	
	private String id;
	
	private String method;
	
	private String name;

	private String bean;
	
	/**
	 * 是否需要登录
	 */
	private boolean login;
	
	/**
	 * 鉴权ID
	 */
	private String privilege;
	
	/**
	 * 是否计入并发数控制
	 */
	private boolean concurrent;
	
	/**
	 * 登陆类型
	 */
	private String loginType;
	
	/**
	 * webservice拦截器
	 */
	private String intercepter;
	
	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public boolean isConcurrent() {
		return concurrent;
	}

	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getIntercepter() {
		return intercepter;
	}

	public void setIntercepter(String intercepter) {
		this.intercepter = intercepter;
	}
	
}
