package com.xinfan.msgbox.core.listener;

import java.util.List;

import com.xinfan.msgbox.vo.CachedMessage;

public interface MessageMatchedListener {
	@Deprecated
	void onMessageMatched(CachedMessage interests,CachedMessage message);
	void onMessageMatched(CachedMessage message,List<CachedMessage> matchs,List<Double> scores);
}
