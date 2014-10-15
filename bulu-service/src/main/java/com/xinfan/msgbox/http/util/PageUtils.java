package com.xinfan.msgbox.http.util;

import java.util.Map;

public class PageUtils {

	public static void calCurrentRow(Map map) {

		String pageNo = String.valueOf(map.get("pageNo"));
		String pageSize = String.valueOf(map.get("pageSize"));

		if (pageNo == null || pageNo.length() == 0 || pageNo.equals("null")) {
			pageNo = "1";
		}

		if (pageSize == null || pageSize.length() == 0|| pageNo.equals("null")) {
			pageSize = "20";
		}

		int currentRow = (Integer.parseInt(pageNo)-1) * Integer.parseInt(pageSize);

		map.put("currentRow", currentRow);

	}

}
