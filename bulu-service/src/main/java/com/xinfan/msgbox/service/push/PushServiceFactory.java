package com.xinfan.msgbox.service.push;

public class PushServiceFactory {

	public static final String PUSH_NAME_GETUI = "getui";

	static PushService getuiService = new GetuiPushService();

	public static PushService getDefaultService() {

		return getPushService(PUSH_NAME_GETUI);
	}

	public static PushService getPushService(String name) {

		if (name.equals("getui")) {
			return getuiService;
		}

		return null;

	}

}
