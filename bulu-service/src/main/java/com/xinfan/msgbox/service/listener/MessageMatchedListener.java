package com.xinfan.msgbox.service.listener;

import com.xinfan.msgbox.vo.CachedMessage;

public interface MessageMatchedListener {
	void onMessageMatched(CachedMessage interests,CachedMessage message);
}
