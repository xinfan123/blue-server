package com.xinfan.msgbox.test;

import com.xinfan.msgbox.common.security.Md5PwdFactory;

public class EncPasswordTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String md5 = Md5PwdFactory.getUserMd5PwdEncoder().encodePassword("1");
		System.out.println(md5);
	}

}
