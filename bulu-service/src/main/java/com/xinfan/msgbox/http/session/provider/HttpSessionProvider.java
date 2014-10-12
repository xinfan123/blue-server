package com.xinfan.msgbox.http.session.provider;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * HttpSession提供类
 * 
 * @author cyp
 */
public class HttpSessionProvider implements SessionProvider {

	private int sessionTimeout = 30;

	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		} else {
			return null;
		}
	}

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(sessionTimeout * 60);
		session.setAttribute(name, value);
	}

	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(sessionTimeout * 60);
		return session.getId();
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		ProviderUtils.clear(request, response);
	}

	public boolean refresh(HttpServletRequest request) {
		return true;
	}

	public int getSessionTimeout() {
		return this.sessionTimeout;
	}

	public String generateSessionId(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(sessionTimeout * 60);
		return session.getId();
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
	
}
