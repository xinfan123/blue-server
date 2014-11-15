package com.xinfan.msgbox.test;

import java.io.IOException;

import org.junit.Test;

import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.service.dao.entity.Message;

public class MessageCacheTest extends BaseTest{
 
	@Test
	public void testCacheContext()
	{
		initSpring();
		
		MessageContext context = MessageContext.getInstance();
		
		Message message = new Message();
		message.setMsgId(1L);
		message.setContext("你想看看");
		message.setCreateUserId(5L);
		//facade.sendMessage(100, new Message());
		if(true)
		{
			context.sendMessage(5L, message);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Message message2 = new Message();
			message2.setMsgId(2L);
			message2.setContext("你想看看");
			message2.setCreateUserId(1L);
			context.addUserInterestMsg(1L, message2);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
