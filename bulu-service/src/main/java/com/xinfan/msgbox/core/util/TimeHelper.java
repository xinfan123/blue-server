package com.xinfan.msgbox.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date getMaxDeadTime() {
		try {
			return sdf.parse("2099-01-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new Date();
	}

	public static Date getDefaultDeadTime() {
		return new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000 * 12);
	}
}
