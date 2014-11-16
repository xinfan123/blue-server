package com.xinfan.msgbox.test;
import org.apache.commons.lang.StringUtils;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "明天有人去长沙玩没";
		String s2 = "明天天气怎么样";
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			int dis = StringUtils.getLevenshteinDistance(s1, s2);
			System.out.println(dis);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(" 耗费时间： " + (t2 - t1) + "  ms ");
	}
}
