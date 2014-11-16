package com.xinfan.msgbox.core.deamon;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.core.messagecache.MessageCache;
import com.xinfan.msgbox.core.vo.CachedMessage;

public class MessageCacheDeamon extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(MessageCacheDeamon.class);

	private MessageCache mcache;

	public MessageCacheDeamon(MessageCache target) {
		mcache = target;
	}

	@Override
	public void run() {
		for (;;) {
			try {
				List<Long> ids = mcache.getAllMessageIds();
				if (!CollectionUtils.isEmpty(ids)) {
					Date now = Calendar.getInstance().getTime();
					for (Iterator<Long> it = ids.iterator(); it.hasNext();) {
						CachedMessage message = mcache.getMessageById(it.next());
						if (null == message)
							continue;
						if (message.getDeadTime().after(now)) {
							mcache.deleteMessage(message);
						}
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}
	}
}
