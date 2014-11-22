package com.xinfan.msgbox.http.util;

import java.util.Calendar;
import java.util.Date;

import com.xinfan.msgbox.http.service.BizConstants;

public class BizUtils {

	/**
	 * @param args
	 */
	public static String getMessageDistanceValue(int sendType) {
		return BizConstants.MESSAGE_MATCH_BY_DISTANCE == sendType ? String.valueOf(BizConstants.DEFAULT_DISTANCE) : "0";
	}

	public static Date getUnreadTimeLimit() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -30);

		return cal.getTime();
	}

}
