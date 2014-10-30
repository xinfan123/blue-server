package com.xinfan.msgbox.test;

import java.io.IOException;

import org.junit.Test;

import com.xinfan.msgbox.service.algorithm.SimpleSimilarityAlgorithm;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.listener.DefaultMessageMatchedListener;
import com.xinfan.msgbox.service.messagecache.MessageCenterFacade;
import com.xinfan.msgbox.service.messagecache.MessageContext;

public class MessageCacheTest extends BaseTest{
 
	@Test
	public void testCacheContext()
	{
		initSpring();
		
		MessageContext context = MessageContext.getInstance();
		context.setInterestProcessorNum(2);
		context.setMessagePoolProcessorNum(2);
		context.setAlgorithm(new SimpleSimilarityAlgorithm());
		context.setMessageMatchedListener(new DefaultMessageMatchedListener());
		context.start();
		
		Message message = new Message();
		message.setMsgId(1L);
		message.setContext("你的考试考");
		message.setCreateUserId(2L);
		//facade.sendMessage(100, new Message());
		if(true)
		{
			context.sendMessage(2L, message);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Message message2 = new Message();
			message2.setMsgId(2L);
			message2.setContext("你想看看");
			message2.setCreateUserId(2L);
			context.addUserInterestMsg(2L, message2);
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
