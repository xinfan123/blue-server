package com.xinfan.msgbox.core.messagecache;

import org.springframework.context.ApplicationContext;

import com.xinfan.msgbox.core.algorithm.SimHashAlgorithm;
import com.xinfan.msgbox.core.listener.DefaultMessageMatchedListener;
import com.xinfan.msgbox.core.util.MessageConsole;
import com.xinfan.msgbox.http.context.ContextPostProcessor;

public class MessageEngineLoader implements ContextPostProcessor {

	@Override
	public void onInit(ApplicationContext context) {
		MessageContext mssageContext = MessageContext.getInstance();
		mssageContext.setInterestProcessorNum(1);
		mssageContext.setMessagePoolProcessorNum(1);
		mssageContext.setAlgorithm(new SimHashAlgorithm());
		mssageContext.setMessageMatchedListener(new DefaultMessageMatchedListener());
		mssageContext.start();
		
		//初始化message engine console
		MessageConsole console = new MessageConsole();
		console.start();
	}


}
