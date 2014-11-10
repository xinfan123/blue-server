package com.xinfan.msgbox.service.messagecache;


import com.xinfan.msgbox.service.listener.MessageChangeListener;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public interface MessageQuery  extends MessageChangeListener{
	void doQuery(MessageQueryInfo queryInfo);
}
