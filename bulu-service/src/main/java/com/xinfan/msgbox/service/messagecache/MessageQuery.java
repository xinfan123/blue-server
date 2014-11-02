package com.xinfan.msgbox.service.messagecache;

import java.util.List;

import com.xinfan.msgbox.vo.CachedMessage;
import com.xinfan.msgbox.vo.MessageQueryInfo;

public interface MessageQuery {
	List<CachedMessage> queryMessage(MessageQueryInfo queryInfo);
}
