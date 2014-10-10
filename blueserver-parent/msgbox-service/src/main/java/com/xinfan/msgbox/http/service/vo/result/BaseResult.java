package com.xinfan.msgbox.http.service.vo.result;

public class BaseResult {
	/**
	 * 服务器未知异常
	 */
	public static final int UNKNOWN_EXCEPTION = -5;
	/**
	 * 服务器业务异常
	 */
	public static final int BIZ_EXCEPTION = -4;
	/**
	 * 并发上限异常
	 */
	public static final int MAX_CONCURRENT = -3;
	/**
	 * 参数不合法异常
	 */
	public static final int PARAMETER_IILAGLE = -2;
	/**
	 * 无权限异常
	 */
	public static final int NO_PRIVILEGE = -1;
	/**
	 * 成功
	 */
	public static final int SUCCESS = 1;

	private int result;

	private String msg;

	public BaseResult() {

	}

	public BaseResult(int result, String msg) {
		super();
		this.result = result;
		this.msg = msg;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	


	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BaseResult putResult(int result) {
		this.setResult(result);
		return this;
	}

	public BaseResult putMsg(String msg) {
		this.setMsg(msg);
		return this;
	}


	public <T extends BaseResult> T paramIllgal(String msg) {
		this.msg = msg;
		this.result = PARAMETER_IILAGLE;
		return (T)this; 
	}
	
	public   <T extends BaseResult> T  success(String msg) {
		this.msg = msg;
		this.result = SUCCESS;
		return (T)this; 
	}
	
	public   <T extends BaseResult> T  noPrivilege(String msg) {
		this.msg = msg;
		this.result = NO_PRIVILEGE;
		return (T)this; 
	}
	public   <T extends BaseResult> T  maxConcurrent(String msg) {
		this.msg = msg;
		this.result = MAX_CONCURRENT;
		return (T)this; 
	}
	public   <T extends BaseResult> T  bizException(String msg) {
		this.msg = msg;
		this.result = BIZ_EXCEPTION;
		return (T)this; 
	}
	public   <T extends BaseResult> T  unKnownException(String msg) {
		this.msg = msg;
		this.result = BIZ_EXCEPTION;
		return (T)this; 
	}

}
