package com.xinfan.msgbox.http.context;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocalLoader {

	public void contextInitialized() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/**/*.bean.xml");
		
		AppContextHolder.setContext(context);
		
		Map<String, ContextPostProcessor> processors = context.getBeansOfType(ContextPostProcessor.class);
		if (processors != null) {
			Iterator it = processors.keySet().iterator();
			while (it.hasNext()) {
				ContextPostProcessor p = processors.get(it.next());
				p.onInit(context);
			}
		}

		
	}

}
