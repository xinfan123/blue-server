package com.xinfan.msgbox.test;

import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.http.context.ContextPostProcessor;

public class BaseTest {
	protected ClassPathXmlApplicationContext context = null;
	@Before
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
