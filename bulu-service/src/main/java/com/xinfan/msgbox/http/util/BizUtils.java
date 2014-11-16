package com.xinfan.msgbox.http.util;

import com.xinfan.msgbox.http.service.BizConstants;

public class BizUtils {

	/**
	 * @param args
	 */
	public static String getMessageDistanceValue(int sendType) {
		return BizConstants.MESSAGE_MATCH_BY_DISTANCE == sendType ? String.valueOf(BizConstants.DEFAULT_DISTANCE) : "0";
	}

}
