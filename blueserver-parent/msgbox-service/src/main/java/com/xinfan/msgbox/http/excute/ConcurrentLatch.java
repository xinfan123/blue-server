package com.xinfan.msgbox.http.excute;

import java.io.Serializable;

/**
 * 
 * 并发计数
 * 
 * @author cyp
 */
public class ConcurrentLatch implements Serializable{

	private static final long serialVersionUID = -7615515346455010235L;

	private int max = 0;
	
	private int current = 0;
	
	public void init(int max){
		this.max = max;
	}

	public void increase() throws ConcurrentException {
		
		if(overflow()){
			throw new ConcurrentException("客户端上传超出最大并发数");
		}
		
		current++;
	}

	public void decrease() {
		current--;

		if (current < 0) {
			current = 0;
		}
	}
	
	public boolean overflow() {
		return max < current;
	}
}
