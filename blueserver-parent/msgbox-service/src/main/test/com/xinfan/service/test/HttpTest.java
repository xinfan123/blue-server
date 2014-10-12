package com.xinfan.service.test;

import org.apache.commons.beanutils.PropertyUtils;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.msgbox.common.MapUtils;
import com.xinfan.msgbox.http.service.vo.FunIdConstants;
import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.LoginParam;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.http.util.HttpUtils;

public class HttpTest {
	public static void main(String[] args) throws Exception {
//		RegisterParam user = new RegisterParam();
//		user.setSessionId("111111111111");
//		user.setFunId("userRegister");
//		
//		user.setMobile("15116239814");
//		user.setPasswd("123");
//		Map map = PropertyUtils.describe(user);
//		System.out.println(map.toString());
		
//		Class<BaseParam> paramClazz = FunIdConstants.GET_USER.getParamClass();
//		Class<UserResult> resultClazz = FunIdConstants.GET_USER.getResultClass();
//		BaseParam param = paramClazz.newInstance();
//		
//		param.setFunId(FunIdConstants.GET_USER.getFunId());
//		param.setUserId(4L);
//		JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
//		System.out.println("return :"+jsonObj.toJSONString());
//		if("1".equals(jsonObj.getString("result"))){
//			UserResult rs = MapUtils.toBean(jsonObj,resultClazz);
//			System.out.println("rs:"+rs);
//		}
		
		login();
		testGetUser();
	}
	
	//登陆   OK!!!
	public static void login()throws Exception{
		String validCode = "";
		
		//获取登陆
		Class<ValidCodeParam> paramClazz = FunIdConstants.GET_LOGIN_VALID_CODE.getParamClass();
		Class<ValidCodeResult> resultClazz = FunIdConstants.GET_LOGIN_VALID_CODE.getResultClass();
		ValidCodeParam param = paramClazz.newInstance();
		
		param.setFunId(FunIdConstants.GET_LOGIN_VALID_CODE.getFunId());
		param.setMobile("15116239811");
		JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
		System.out.println("return :"+jsonObj.toJSONString());
		if("0".equals(jsonObj.getString("result"))){
			ValidCodeResult rs = MapUtils.toBean(jsonObj,resultClazz);
			System.out.println("rs:"+rs);
			validCode = rs.getValidCode();
		}
		
		
		//登陆
		Class<LoginParam> paramClazz_ = FunIdConstants.LOGIN.getParamClass();
		Class<BaseResult> resultClazz_ = FunIdConstants.LOGIN.getResultClass();
		LoginParam param_ = paramClazz_.newInstance();
		
		param_.setFunId(FunIdConstants.LOGIN.getFunId());
		param_.setMobile("15116239811");
		param_.setPasswd("1");
		param_.setValidCode(validCode);
		jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param_));
		System.out.println("return :"+jsonObj.toJSONString());
		if("1".equals(jsonObj.getString("result"))){
			BaseResult rs = MapUtils.toBean(jsonObj,resultClazz_);
			System.out.println("rs:"+rs);
		}
	}
	
	//获取用户信息 ok!!!!
	public static UserResult testGetUser()throws Exception{
		Class<BaseParam> paramClazz = FunIdConstants.GET_USER.getParamClass();
		Class<UserResult> resultClazz = FunIdConstants.GET_USER.getResultClass();
		BaseParam param = paramClazz.newInstance();
		
		param.setFunId(FunIdConstants.GET_USER.getFunId());
		param.setUserId(7L);
		JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
		System.out.println("return :"+jsonObj.toJSONString());
		if("0".equals(jsonObj.getString("result"))){
			UserResult rs = MapUtils.toBean(jsonObj,resultClazz);
			System.out.println("rs:"+rs);
			return rs;
		}
		return null;
	}
	
	/**
	 * 注册接口 ok!!!
	 * @throws Exception
	 */
	public static void testUserRegister()throws Exception{
		String validCode = "";
		
		//获取注册码
		Class<ValidCodeParam> paramClazz = FunIdConstants.GET_USERREGISTER_VALIDCODE.getParamClass();
		Class<ValidCodeResult> resultClazz = FunIdConstants.GET_USERREGISTER_VALIDCODE.getResultClass();
		ValidCodeParam param = paramClazz.newInstance();
		
		param.setFunId(FunIdConstants.GET_USERREGISTER_VALIDCODE.getFunId());
		param.setMobile("15116239811");
		JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
		System.out.println("return :"+jsonObj.toJSONString());
		if("0".equals(jsonObj.getString("result"))){
			ValidCodeResult rs = MapUtils.toBean(jsonObj,resultClazz);
			System.out.println("rs:"+rs);
			validCode = rs.getValidCode();
		}
		
		
		//注册
		Class<RegisterParam> paramClazz_ = FunIdConstants.USER_REGISTER.getParamClass();
		Class<BaseResult> resultClazz_ = FunIdConstants.USER_REGISTER.getResultClass();
		RegisterParam param_ = paramClazz_.newInstance();
		
		param_.setFunId(FunIdConstants.USER_REGISTER.getFunId());
		param_.setMobile("15116239811");
		param_.setPasswd("1");
		param_.setRegEarea("1");
		param_.setRegGpsx("1.0");
		param_.setRegGpsy("2.0");
		param_.setValidCode(validCode);
		jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param_));
		System.out.println("return :"+jsonObj.toJSONString());
		if("1".equals(jsonObj.getString("result"))){
			BaseResult rs = MapUtils.toBean(jsonObj,resultClazz_);
			System.out.println("rs:"+rs);
		}
	}
}
