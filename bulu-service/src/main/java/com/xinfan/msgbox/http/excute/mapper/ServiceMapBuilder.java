package com.xinfan.msgbox.http.excute.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xinfan.msgbox.common.BizException;

/**
 * 
 * @author cyp
 * 
 */
public class ServiceMapBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMapBuilder.class);

	// private InputStream resource;

	private String path;

	// private Document document;

	//private Element root;

	private ServiceMapConfig config;

	public ServiceMapBuilder(ServiceMapConfig config, String configPath) throws IOException, SAXException, ParserConfigurationException {
		this.config = config;
		this.path = configPath;
		//parseXml();
	}

	public void parseXml() {

		try {
			String[] paths = path.split(",");
			for (String p : paths) {
				buildClass(p);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new BizException("parseXml error : " + path);
		}
	}

	private void buildClass(String configPath) throws ParserConfigurationException, SAXException, IOException {
		// 得到DOM解析器的工厂实例
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// 从DOM工厂中获得DOM解析器
		DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
		// 把要解析的xml文档读入DOM解析器
		InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath);
		Document document = dbBuilder.parse(resource);

		NodeList nList = document.getElementsByTagName("service");
		Map<String, ServiceMeta> ss = new HashMap<String, ServiceMeta>();
		for (int i = 0; i < nList.getLength(); i++) {
			Element node = (Element) nList.item(i);
			String id = node.getAttribute("funId");
			String name = node.getAttribute("name");
			String method = node.getAttribute("method");
			String bean = node.getAttribute("bean");
			String login = node.getAttribute("login");
			String privilege = node.getAttribute("privilege");
			String concurrent = node.getAttribute("concurrent");
			String loginType = node.getAttribute("loginType");
			String intercepter = node.getAttribute("intercepter");

			if (id == null || id.trim().length() == 0) {
				LOGGER.warn(" service.mapping.xml id has null");
				continue;
			}
			if (bean == null || bean.trim().length() == 0) {
				LOGGER.warn(" service.mapping.xml bean has null");
				continue;
			}

			id = id.trim().toUpperCase();
			bean = bean.trim();

			ServiceMeta meta = new ServiceMeta();
			meta.setFunId(id.trim());
			meta.setName(name);
			meta.setBean(bean);
			meta.setPrivilege(privilege);
			meta.setLoginType(loginType);
			meta.setIntercepter(intercepter);
			if ("true".equalsIgnoreCase(concurrent)) {
				meta.setConcurrent(true);
			}

			// 默认
			if (method == null || method.trim().length() == 0) {
				meta.setMethod("execute");
			} else {
				meta.setMethod(method.trim());
			}
			// 是否需要登录
			if ("true".equalsIgnoreCase(login)) {
				meta.setLogin(true);
			}

			ss.put(id, meta);
		}
		config.appendClasses(ss);
	}

	public void build() {
		parseXml();
	}

	public ServiceMapConfig getServiceConfig() {
		return this.config;
	}
}
