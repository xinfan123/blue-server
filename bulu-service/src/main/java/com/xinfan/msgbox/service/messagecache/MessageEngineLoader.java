package com.xinfan.msgbox.service.messagecache;

import org.springframework.context.ApplicationContext;

import com.xinfan.msgbox.http.context.ContextPostProcessor;
import com.xinfan.msgbox.service.algorithm.SimpleSimilarityAlgorithm;
import com.xinfan.msgbox.service.listener.DefaultMessageMatchedListener;
import com.xinfan.msgbox.util.MessageConsole;

public class MessageEngineLoader implements ContextPostProcessor {

	@Override
	public void onInit(ApplicationContext context) {
		MessageContext mssageContext = MessageContext.getInstance();
		mssageContext.setInterestProcessorNum(1);
		mssageContext.setMessagePoolProcessorNum(0);
		mssageContext.setAlgorithm(new SimpleSimilarityAlgorithm());
		mssageContext.setMessageMatchedListener(new DefaultMessageMatchedListener());
		mssageContext.start();
		
		//初始化message engine console
		MessageConsole console = new MessageConsole();
		console.start();
	}


}
