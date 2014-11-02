package com.xinfan.msgbox.service.deamon;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.service.messagecache.MessageCache;
import com.xinfan.msgbox.vo.CachedMessage;

public class MessageCacheDeamon extends Thread{
	
	private MessageCache mcache;
	
	public MessageCacheDeamon(MessageCache target) {
		mcache = target;
	}
	
	@Override
	public void run() {
		for(;;)
		{
			try{
				List<Long> ids = mcache.getAllMessageIds();
				if(!CollectionUtils.isEmpty(ids))
				{
					Date now = Calendar.getInstance().getTime();
					for(Iterator<Long> it = ids.iterator();it.hasNext();)
					{
						CachedMessage message = mcache.getMessageById(it.next());
						if(null == message) continue;
						if(message.getDeadTime().after(now))
						{
							mcache.deleteMessage(message);
						}
					}
					
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	}

}
