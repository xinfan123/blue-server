package com.xinfan.msgbox.http.session.id;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;


/**
 * JDKUUID生成 session id
 * 
 * @author cyp
 *
 */
public class JdkUUIDGenerator implements SessionIdGenerator {
	public String get() {
		return StringUtils.remove(UUID.randomUUID().toString(), '-');
	}

	public static void main(String[] args) {
		UUID.randomUUID();
		long time = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			System.out.println(UUID.randomUUID());
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}
}
