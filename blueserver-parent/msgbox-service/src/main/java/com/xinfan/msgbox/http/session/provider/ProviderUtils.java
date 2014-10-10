package com.xinfan.msgbox.http.session.provider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProviderUtils {
	/**
	 * cookie session键值
	 */
	public static String getRequestedSessionId(HttpServletRequest request) {
		String sid = request.getRequestedSessionId();
		String ctx = request.getContextPath();
		
		String sessionId = (String) request.getAttribute(SessionProvider.CURRENT_SESSION_ID);
		if (sessionId != null && sessionId.length() > 0) {
			return sessionId;
		}
		
		sessionId = (String) request.getSession().getAttribute(SessionProvider.CURRENT_SESSION_ID);
		if (sessionId != null && sessionId.length() > 0) {
			return sessionId;
		}
		
		// 手动从cookie获取
		Cookie cookie = getCookie(request, SessionProvider.COOKIE_SESSION_ID);
		if (cookie != null) {
			return cookie.getValue();
		} else {
			return null;
		}
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
	
	public static Cookie createCookie(HttpServletRequest request, String value) {
		Cookie cookie = new Cookie(SessionProvider.COOKIE_SESSION_ID, value);
		String ctx = request.getContextPath();
		cookie.setPath((ctx == null || ctx.length() == 0) ? "/" : ctx);
		return cookie;
	}
	
	public static void clear(HttpServletRequest request, HttpServletResponse response) {
		
		String root = ProviderUtils.getRequestedSessionId(request);
		
		request.removeAttribute(SessionProvider.CURRENT_SESSION_ID);

		request.getSession().invalidate();
		
		if (root != null && root.trim().length() > 0) {
			Cookie cookie = createCookie(request, null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
}
