package com.xinfan.msgbox.cache;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * 远程缓存实现类
 * 
 * @author cyp
 * 
 */
public class MemcachedCacheProvider implements CacheProvider, InitializingBean, DisposableBean {
	private MemcachedClient client;
	private String servers;
	private Integer[] weights;
	private String cacheName;

	public Object getAttribute(String root) {
		return client.get(root);
	}

	public void setAttribute(String root, Serializable session, int exp) {
		client.set(root, exp * 60, session);
	}

	public Serializable getAttribute(String root, String name) {
		HashMap<String, Serializable> session = (HashMap<String, Serializable>) getAttribute(root);
		return session != null ? session.get(name) : null;
	}

	public void setAttribute(String root, String name, Serializable value, int exp) {
		HashMap<String, Serializable> session = (HashMap<String, Serializable>) getAttribute(root);
		if (session == null) {
			session = new HashMap<String, Serializable>();
		}
		session.put(name, value);

		client.set(root, exp * 60, session);
	}

	public void clear(String root) {
		client.delete(root);
	}

	public boolean exist(String root) {
		return client.get(root) != null;
	}

	public void afterPropertiesSet() throws Exception {

		String[] ss = servers.split("\\s{1,}");
		List<InetSocketAddress> addr = new ArrayList<InetSocketAddress>(ss.length);

		int index;
		for (String s : ss) {
			index = s.indexOf(":");
			addr.add(new InetSocketAddress(s.substring(0, index), Integer.parseInt(s.substring(index + 1))));
		}
		client = new MemcachedClient(addr);

		CacheHolder.getInstance().addCacheProvider(this.cacheName, this);
	}

	public void destroy() throws Exception {
		client.shutdown();
	}

	public Integer[] getWeights() {
		return weights;
	}

	public void setWeights(Integer[] weights) {
		this.weights = weights;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public static void main(String[] args) {
		String servers = "127.0.0.1:11211             192.168.1.200:11211 ";
		String[] ss = servers.split("\\s{1,}");

		System.out.println(ss.length);
		for (String s : ss) {
			System.out.println(s);
		}
	}

	@Override
	public Object getTouchAttribute(String root, String name, int exp) {
		CASValue value = client.getAndTouch(root, exp);

		if (value == null) {
			return null;
		}

		HashMap<String, Serializable> session = (HashMap<String, Serializable>) value.getValue();

		if (session == null) {
			return null;
		}

		return session.get(name);
	}

	@Override
	public Object getTouchAttribute(String root, int exp) {

		CASValue value = client.getAndTouch(root, exp);

		if (value == null) {
			return null;
		}

		return value.getValue();
	}

	@Override
	public void touch(String root, String name, int exp) {
		client.touch(root, exp);
	}

	@Override
	public void touch(String root, int exp) {
		client.touch(root, exp);
	}
}
