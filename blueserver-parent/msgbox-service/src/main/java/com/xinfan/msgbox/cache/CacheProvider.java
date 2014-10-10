package com.xinfan.msgbox.cache;

import java.io.Serializable;

/**
 * 
 * 通用缓存接口
 * 
 * @author cyp
 *
 */
public interface CacheProvider {
	
	public Object getAttribute(String root, String name);
	
	public Object getAttribute(String root);
	
	public Object getTouchAttribute(String root,String name,int exp);
	
	public Object getTouchAttribute(String root,int exp);

	public void setAttribute(String root, String name, Serializable value, int exp);
	
	public void setAttribute(String root,Serializable value, int exp);

	public void clear(String root);

	public boolean exist(String root);

	public void touch(String root, String name, int exp);

	public void touch(String root, int exp);
	
}
