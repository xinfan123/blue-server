package com.xinfan.msgbox.core.messagecache;


import com.xinfan.msgbox.core.listener.MessageChangeListener;
import com.xinfan.msgbox.core.vo.MessageQueryInfo;

public interface MessageQuery  extends MessageChangeListener{
	void doQuery(MessageQueryInfo queryInfo);
}
