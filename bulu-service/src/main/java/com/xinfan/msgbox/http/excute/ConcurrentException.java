package com.xinfan.msgbox.http.excute;

/**
 * 
 * 客户端并发异常
 * 
 * @author cyp
 *
 */
public class ConcurrentException extends Exception {

	private static final long serialVersionUID = -6943620778967183383L;

	public ConcurrentException(String msg){
		super(msg);
	}
}
