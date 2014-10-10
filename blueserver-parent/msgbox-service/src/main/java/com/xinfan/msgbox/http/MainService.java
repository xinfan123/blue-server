package com.xinfan.msgbox.http;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfan.msgbox.common.JSONUtils;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.excute.ServiceExecuter;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.util.RequestUtils;
import com.xinfan.msgbox.http.util.ResponseUtils;

/**
 * 对外服务统一入口类
 * 
 * @author cyp
 */
public class MainService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(MainService.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainService() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BaseResult result = null;
		try {
			//将request、response 绑定至线程变量中
			ServiceContext.bind(request, response);
			
			
			Map<String,Object> paramters = RequestUtils.getRequestJSONParams(request);
			log.debug("####################inputput:"+JSONUtils.toJSONString(paramters));
			
			//调用方法
			result = ServiceExecuter.process(paramters);
			String json = JSONUtils.toJSONString(result);
			ResponseUtils.renderJson(response, json);
			log.debug("####################output:"+json);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			String json = JSONUtils.toJSONString(result);
			ResponseUtils.renderJson(response, json);
		}finally{
			ServiceContext.unbind(request, response);
		}
	}

	

}
