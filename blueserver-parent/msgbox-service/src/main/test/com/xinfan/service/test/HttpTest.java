package com.xinfan.service.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.msgbox.common.MapUtils;
import com.xinfan.msgbox.http.service.vo.FunIdConstants;
import com.xinfan.msgbox.http.service.vo.param.UserInfoParam;
import com.xinfan.msgbox.http.service.vo.result.UserInfoResult;
import com.xinfan.msgbox.http.util.HttpUtils;

public class HttpTest {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
//		RegisterParam user = new RegisterParam();
//		user.setSessionId("111111111111");
//		user.setFunId("userRegister");
//		
//		user.setMobile("15116239814");
//		user.setPasswd("123");
//		Map map = PropertyUtils.describe(user);
//		System.out.println(map.toString());
		
		Class<UserInfoParam> paramClazz = FunIdConstants.GET_USER_INFO.getParamClass();
		Class<UserInfoResult> resultClazz = FunIdConstants.GET_USER_INFO.getResultClass();
		UserInfoParam param = paramClazz.newInstance();
		
		param.setFunId(FunIdConstants.GET_USER_INFO.getFunId());
		param.setUserId(4L);
		JSONObject jsonObj = HttpUtils.httpInvokerJson2(PropertyUtils.describe(param));
		UserInfoResult rs = MapUtils.toBean(jsonObj,resultClazz);
		System.out.println("rs:"+rs);
	}
}
