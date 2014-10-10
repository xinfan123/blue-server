package com.xinfan.msgbox.http.session.provider;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Session提供者
 * @author cyp
 */
public interface SessionProvider {
	
	public static final String COOKIE_SESSION_ID = "_JSESSION_COOKIE";
	
	public static final String CURRENT_SESSION_ID = "_current_session_id";
	
	public Serializable getAttribute(HttpServletRequest request, String name);

	public void setAttribute(HttpServletRequest request,
			HttpServletResponse response, String name, Serializable value);

	public String getSessionId(HttpServletRequest request,
			HttpServletResponse response);

	public void logout(HttpServletRequest request, HttpServletResponse response);
	
	public boolean refresh(HttpServletRequest request);
	
	public int getSessionTimeout();
	
	public String generateSessionId(HttpServletRequest request,HttpServletResponse response);
	
}
