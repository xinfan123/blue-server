package com.xinfan.service.test;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.http.context.ContextPostProcessor;

public class BaseTest {
	protected static ClassPathXmlApplicationContext context = null;
	public void initSpring(){
		context = new ClassPathXmlApplicationContext("classpath*:/config/**/*.bean.xml");
		AppContextHolder.setContext(context);
		Map<String,ContextPostProcessor> processors = context.getBeansOfType(ContextPostProcessor.class);
		if (processors != null) {
			Iterator it = processors.keySet().iterator();
			while(it.hasNext()){
				ContextPostProcessor p = processors.get(it.next());
				p.onInit(context);
			}
		}
	}
}
