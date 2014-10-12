package com.xinfan.msgbox.http.session;

import java.util.HashMap;
import java.util.Map;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.http.session.provider.SessionProvider;

public class SessionFactory {

	public static final String DEFAULT_PROVIDER_NAME = "HttpSessionProvider";
	public static final String WEBSERVICE_PROVIDER_NAME = "WebServiceProvider";
	
	
	private static SessionFactory instance = null;
	
	private Map<String,SessionProvider> providers = new HashMap<String,SessionProvider>();

	private SessionFactory() {

	}

	public static synchronized SessionProvider getProvider(String id) {
		if (instance == null) {
			init();
		}
		return instance.providers.get(id);
	}

	public static synchronized SessionProvider getProvider() {
		return getProvider(DEFAULT_PROVIDER_NAME);
	}

	private static synchronized void  init() {
		instance = new SessionFactory();
		instance.providers = AppContextHolder.getBeansOfType(SessionProvider.class);
	}
}
