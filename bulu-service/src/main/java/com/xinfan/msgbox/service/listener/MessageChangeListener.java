package com.xinfan.msgbox.service.listener;

import java.util.List;

public interface MessageChangeListener {
	void onMessageAdded(List<Long> msgIds);
	void onMessageUpdated(List<Long> msgIds);
	void onMessageDeleted(List<Long> msgIds);
}
