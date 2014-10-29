package com.xinfan.msgbox.service.listener;

import com.xinfan.msgbox.vo.CachedMessage;

public class DefaultMessageMatchedListener implements MessageMatchedListener{

	@Override
	public void onMessageMatched(CachedMessage interests, CachedMessage message) {
		System.out.println(Thread.currentThread().getName() + "send message :" + message.getOriginalMsg() + " to " + interests.getUserId());
	}

}
