package com.xinfan.msgbox.http.session.provider;

import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinfan.msgbox.cache.CacheProvider;
import com.xinfan.msgbox.http.session.id.SessionIdGenerator;

/**
 * 使用缓存实现Session
 * 
 * @author cyp
 */
public class MemcacheSessionProvider implements SessionProvider {

	private CacheProvider cache;

	private SessionIdGenerator sessionIdGenerator;

	private int sessionTimeout = 30;

	@SuppressWarnings("unchecked")
	public Serializable getAttribute(HttpServletRequest request, String name) {
		// 为了避免同一个请求多次获取缓存session，所以将缓存session保存至request中。

		String sessionId = ProviderUtils.getRequestedSessionId(request);

		if (sessionId == null || sessionId.trim().length() == 0) {
			return null;
		}

		HashMap<String, Serializable> session = (HashMap<String, Serializable>) cache.getAttribute(sessionId);

		if (session != null) {
			return session.get(name);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
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

		String root = (String) request.getAttribute(CURRENT_SESSION_ID);
		if (root != null && root.length() > 0) {
			return root;
		}

		root = (String) request.getSession().getAttribute(CURRENT_SESSION_ID);
		if (root != null && root.length() > 0) {
			return root;
		}

		Cookie cookie = ProviderUtils.getCookie(request, SessionProvider.COOKIE_SESSION_ID);

		if (cookie != null) {
			request.setAttribute(CURRENT_SESSION_ID, cookie.getValue());
			request.getSession().setAttribute(CURRENT_SESSION_ID, cookie.getValue());
			return cookie.getValue();
		}

		return null;
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) {
		String root = ProviderUtils.getRequestedSessionId(request);

		ProviderUtils.clear(request, response);

		if (root != null && root.length() > 0) {
			cache.clear(root);
		}
	}

	/**
	 * 设置session过期时间
	 * 
	 * @param sessionTimeout
	 *            分钟
	 */
	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public void setSessionIdGenerator(SessionIdGenerator sessionIdGenerator) {
		this.sessionIdGenerator = sessionIdGenerator;
	}

	public boolean refresh(HttpServletRequest request) {

		String root = ProviderUtils.getRequestedSessionId(request);

		if (root == null || root.length() == 0) {
			return false;
		}

		Object session = cache.getTouchAttribute(root, sessionTimeout);
		return session != null;
	}

	public int getSessionTimeout() {
		return this.getSessionTimeout();
	}

	public String generateSessionId(HttpServletRequest request,HttpServletResponse response) {
		
		String sessionId = sessionIdGenerator.get();

		request.setAttribute(SessionProvider.CURRENT_SESSION_ID, sessionId);
		request.getSession().setAttribute(SessionProvider.CURRENT_SESSION_ID, sessionId);
		
		Cookie cookie = ProviderUtils.createCookie(request, sessionId);
		response.addCookie(cookie);

		return sessionId;
	}

	public SessionIdGenerator getSessionIdGenerator() {
		
		return sessionIdGenerator;
	}

	public CacheProvider getCache() {
		return cache;
	}

	public void setCache(CacheProvider cache) {
		this.cache = cache;
	}

}
