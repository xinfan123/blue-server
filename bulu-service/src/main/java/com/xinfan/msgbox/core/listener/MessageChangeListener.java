package com.xinfan.msgbox.core.listener;

import com.xinfan.msgbox.vo.CachedMessage;

public interface MessageChangeListener {
	void onMessageAdded(CachedMessage msg);
	void onMessageUpdated(CachedMessage old,CachedMessage msg);
	void onMessageDeleted(CachedMessage msg);
//	void onMessageAdded(List<Long> msgIds);
//	void onMessageUpdated(List<Long> msgIds);
//	void onMessageDeleted(List<Long> msgIds);
}
