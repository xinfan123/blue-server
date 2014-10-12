/**
 * 
 */
package com.xinfan.msgbox.http.context;

import org.springframework.context.ApplicationContext;

/**
 * @author cyp
 *
 */
public interface ContextPostProcessor {
	
	void onInit(ApplicationContext context);
}
