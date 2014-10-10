package com.xinfan.msgbox.http.excute;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.xinfan.msgbox.common.BizException;
import com.xinfan.msgbox.common.MapUtils;
import com.xinfan.msgbox.config.ServiceMapConfig;
import com.xinfan.msgbox.config.ServiceMeta;
import com.xinfan.msgbox.config.WsFileConfig;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.context.AppContextHolder;
import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;

/**
 * http 服务调用类
 * 
 * @author cyp
 * 
 */
public class ServiceExecuter {

	private static final Logger logger = LoggerFactory.getLogger(ServiceExecuter.class);

	private static Object lock = new Object();

	private static ConcurrentLatch latch;

	public static BaseResult process(Map<String,Object> parameters) {
		HttpServletRequest request = (HttpServletRequest) ServiceContext.getRequest();
		
		String clazzStr = (String) parameters.get("class");
		if(StringUtils.isEmpty(clazzStr)){
			return new BaseResult().paramIllgal("参数错误，必须包含class参数 ");
		}
		Class clazz = null;
		try {
			clazz = Class.forName(clazzStr.substring(clazzStr.indexOf("com")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return new BaseResult().bizException("参数错误，找不到参数对应的class");
		}
		BaseParam param = MapUtils.toBean(parameters, clazz);
		
		ServiceMeta meta = ServiceMapConfig.getInstance().getService(param.getFunId().toUpperCase());
		if (meta == null) {
			return new BaseResult().paramIllgal("FUNID 参数错误，没有指定的服务 ");
		}
		
		try {
			logger.info("################# start invoke service " + meta.getId() + " ");
			logger.debug("################# invoke service " + meta.getId() + " input paramters ： ");

			// 作权限判定
			boolean toInvoke = doPrivilege(request, meta, param);
			if (!toInvoke) {
				return new BaseResult().noPrivilege("没有权限");
			}
			
			increaseConcurrentCount(meta);
			
			BaseResult rs = invoke(meta, param);

			logger.info("################# invoke service " + meta.getId() + " success");
			return rs;
		} catch (ConcurrentException e) {
			logger.error(e.getMessage(), e);
			logger.info("################# invoke service " + meta.getId() + " error");
			return new BaseResult().maxConcurrent("已达并发上限，请稍后传送");
		}catch (BizException e) {
			logger.error(e.getMessage(), e);
			logger.info("################# invoke service " + meta.getId() + " error");
			return new BaseResult().bizException("业务处理异常,exception:"+e.getMessage());
		} 
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.info("################# invoke service " + meta.getId() + " error");
			return new BaseResult().unKnownException("未知处理异常,exception:"+e.getMessage());
		} finally {
			decreaseConcurrentCount(meta);
		}
	}

	/**
	 * 并发计数
	 */
	public static void increaseConcurrentCount(ServiceMeta meta) throws ConcurrentException {
		if (meta.isConcurrent()) {
			synchronized (lock) {
				if (latch == null) {
					int max = WsFileConfig.getInstance().getInt("upload.concurrent.max");
					latch = new ConcurrentLatch();
					latch.init(max);
				}
				latch.increase();
			}
		}
	}

	public static void decreaseConcurrentCount(ServiceMeta meta) {
		if (meta.isConcurrent()) {
			synchronized (lock) {
				if (latch != null) {
					latch.decrease();
				}
			}
		}
	}


	private static boolean doPrivilege(HttpServletRequest request, ServiceMeta meta, BaseParam param) {
		return true;
	}

	public static BaseResult invoke(ServiceMeta meta, BaseParam param) throws Exception {
		String bean = meta.getBean();
		ApplicationContext app = AppContextHolder.getContext();
		Object serviceBean = app.getBean(bean);
		Class cls = serviceBean.getClass();
		Method method = cls.getMethod(meta.getMethod(), param.getClass());
		if(method == null){
			return new BaseResult().bizException("此服务不可用");
		}
		BaseResult result = (BaseResult) method.invoke(serviceBean,param);
		return result;
	}
}
