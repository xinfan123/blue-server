package com.xinfan.msgbox.http.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

	public static Date getValidTime(Date publishTime, int durationTime) {

		if (publishTime == null) {
			publishTime = new Date();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(publishTime);
		c.add(Calendar.MINUTE, durationTime);

		return c.getTime();

	}

}
