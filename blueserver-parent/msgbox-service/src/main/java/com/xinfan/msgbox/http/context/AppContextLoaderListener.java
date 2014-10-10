package com.xinfan.msgbox.http.context;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;

/**
 * 
 * 定制由web启动的容器加载类
 * 
 * @author cyp
 *
 */
public class AppContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {
	
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		//加载完成通知上下文持上类保存 
		
		String contextpath = event.getServletContext().getContextPath();
		if (contextpath.equals("/")) {
			event.getServletContext().setAttribute("contextpath", "");
		} else {
			event.getServletContext().setAttribute("contextpath", contextpath);
		}
		
		AppContextHolder.setContext(getCurrentWebApplicationContext());
		
		ApplicationContext context = getCurrentWebApplicationContext();
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
