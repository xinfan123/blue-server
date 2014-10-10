/**
 * 
 */
package com.xinfan.msgbox.http.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyp
 * 
 */
public class ServiceContext {

	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();

	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	public static void bind(HttpServletRequest request, HttpServletResponse response) {
		requestLocal.set(request);
		responseLocal.set(response);
	}

	public static void unbind(HttpServletRequest request, HttpServletResponse response) {
		requestLocal.remove();
		responseLocal.remove();
	}

	public static HttpServletRequest getRequest() {
		return requestLocal.get();
	}

	public static HttpServletResponse getResponse() {
		return responseLocal.get();
	}

}
