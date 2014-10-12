package com.xinfan.msgbox.http.session.provider;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinfan.msgbox.cache.CacheProvider;
import com.xinfan.msgbox.http.session.id.SessionIdGenerator;

/**
 * HttpSession提供类
 * 
 * @author cyp
 */
public class WebServiceProvider implements SessionProvider {

	private CacheProvider cache;

	private int sessionTimeout = 30;

	private SessionIdGenerator sessionIdGenerator;

	public Serializable getAttribute(HttpServletRequest request, String name) {
		String root = ProviderUtils.getRequestedSessionId(request);
		if (root == null || root.length() == 0) {
			return null;
		}

		HashMap<String, Serializable> session = (HashMap<String, Serializable>) cache.getAttribute(root);

		if (session != null) {
			return (Serializable) session.get(name);
		} else {
			return null;
		}
	}

	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value) {

		String root = ProviderUtils.getRequestedSessionId(request);
		if (root == null || root.length() == 0) {
			return;
		}

		HashMap<String, Serializable> session = (HashMap<String, Serializable>) cache.getAttribute(root);
		if (session == null) {
			session = new HashMap<String, Serializable>();
		}
		session.put(name, value);
		cache.setAttribute(root, session, sessionTimeout);
	}

	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		String root = ProviderUtils.getRequestedSessionId(request);
		return root;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		String root = ProviderUtils.getRequestedSessionId(request);
		
		ProviderUtils.clear(request, response);
		
		if (root != null && root.length() > 0) {
			cache.clear(root);
		}
	}

	public boolean refresh(HttpServletRequest request) {
		String root = ProviderUtils.getRequestedSessionId(request);
		if (root == null || root.length() == 0) {
			return false;
		}
		cache.touch(root, sessionTimeout);
		return true;
	}

	public int getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public String generateSessionId(HttpServletRequest request,HttpServletResponse response) {
		
		String sessionId = sessionIdGenerator.get();

		request.setAttribute(SessionProvider.CURRENT_SESSION_ID, sessionId);
		request.getSession().setAttribute(SessionProvider.CURRENT_SESSION_ID, sessionId);
		
		Cookie cookie = ProviderUtils.createCookie(request, sessionId);
		response.addCookie(cookie);

		return sessionId;
	}

	public CacheProvider getCache() {
		return cache;
	}

	public void setCache(CacheProvider cache) {
		this.cache = cache;
	}

	public SessionIdGenerator getSessionIdGenerator() {
		return sessionIdGenerator;
	}

	public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
		this.sessionIdGenerator = sessionIdGenerator;
	}

}
