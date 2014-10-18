package com.xinfan.service.test;

import org.apache.commons.beanutils.PropertyUtils;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.msgbox.common.MapUtils;
import com.xinfan.msgbox.http.service.vo.FunIdConstants;
import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdBeforeLoginParam;
import com.xinfan.msgbox.http.service.vo.param.LoginParam;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserSetParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserResult;
import com.xinfan.msgbox.http.service.vo.result.UserSetResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.http.util.HttpUtils;

public class HttpTest extends BaseTest{
	public static void main(String[] args) throws Exception {
		
//		login();
		testUserChangePwdBeforLogin();
//		testGetUser();
//		testSetUserSet();
//		testGetUserSet();
	}
	
	//登陆   OK!!!
	public static void login()throws Exception{
		
		//登陆
		Class<LoginParam> paramClazz_ = FunIdConstants.LOGIN.getParamClass();
		Class<BaseResult> resultClazz_ = FunIdConstants.LOGIN.getResultClass();
		LoginParam param_ = paramClazz_.newInstance();
		
		param_.setFunId(FunIdConstants.LOGIN.getFunId());
		param_.setMobile("15116239811");
		param_.setPasswd("1");
		JSONObject  jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param_));
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
		param_.setRegGpsy("姜永霞");
		param_.setValidCode(validCode);
		jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param_));
		System.out.println("return :"+jsonObj.toJSONString());
		if("1".equals(jsonObj.getString("result"))){
			BaseResult rs = MapUtils.toBean(jsonObj,resultClazz_);
			System.out.println("rs:"+rs);
		}
	}
	
	//用户设置  ok!!!!
	public static BaseResult testSetUserSet()throws Exception{
		Class<UserSetParam> paramClazz = FunIdConstants.SET_USERSET.getParamClass();
		Class<BaseResult> resultClazz = FunIdConstants.SET_USERSET.getResultClass();
		UserSetParam param = paramClazz.newInstance();
		
		param.setFunId(FunIdConstants.SET_USERSET.getFunId());
		param.setMaxCount(0);
		param.setMinAmmount(0);
		param.setMinCredit(0);
		param.setVibrate(0);
		param.setVoice(0);
		param.setNewMsgNotify(0);
		param.setSimilarLevel(0);
		JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
		System.out.println("return :"+jsonObj.toJSONString());
		if("0".equals(jsonObj.getString("result"))){
			BaseResult rs = MapUtils.toBean(jsonObj,resultClazz);
			System.out.println("rs:"+rs);
			return rs;
		}
		return null;
	}
	
		//获取用户设置  ok!!!!
		public static BaseResult testGetUserSet()throws Exception{
			Class<BaseParam> paramClazz = FunIdConstants.GET_USERSET.getParamClass();
			Class<UserSetResult> resultClazz = FunIdConstants.GET_USERSET.getResultClass();
			BaseParam param = paramClazz.newInstance();
			
			param.setFunId(FunIdConstants.GET_USERSET.getFunId());
			JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
			System.out.println("return :"+jsonObj.toJSONString());
			if("0".equals(jsonObj.getString("result"))){
				UserSetResult rs = MapUtils.toBean(jsonObj,resultClazz);
				System.out.println("rs:"+rs);
				return rs;
			}
			return null;
		}
		
		
		/**
		 * 修改密码 ok!!!
		 * @throws Exception
		 */
		public static void testUserChangePwdBeforLogin()throws Exception{
			String validCode = "";
			
			//获取验证码
			Class<ValidCodeParam> paramClazz = FunIdConstants.GET_CHANGE_PASSWORD_VALID_CODE.getParamClass();
			Class<ValidCodeResult> resultClazz = FunIdConstants.GET_CHANGE_PASSWORD_VALID_CODE.getResultClass();
			ValidCodeParam param = paramClazz.newInstance();
			
			param.setFunId(FunIdConstants.GET_CHANGE_PASSWORD_VALID_CODE.getFunId());
			param.setMobile("15116239811");
			JSONObject jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param));
			System.out.println("return :"+jsonObj.toJSONString());
			if("0".equals(jsonObj.getString("result"))){
				ValidCodeResult rs = MapUtils.toBean(jsonObj,resultClazz);
				System.out.println("rs:"+rs);
				validCode = rs.getValidCode();
			}
			
			
			//修改密码
			Class<ChangePasswdBeforeLoginParam> paramClazz_ = FunIdConstants.CHANGE_PASSWD_BEFORE_LOGIN.getParamClass();
			Class<BaseResult> resultClazz_ = FunIdConstants.CHANGE_PASSWD_BEFORE_LOGIN.getResultClass();
			ChangePasswdBeforeLoginParam param_ = paramClazz_.newInstance();
			
			param_.setFunId(FunIdConstants.CHANGE_PASSWD_BEFORE_LOGIN.getFunId());
			param_.setMobile("15116239811");
			param_.setValidCode(validCode);
			param_.setNewPasswd("234");
			jsonObj = HttpUtils.httpInvokerJson(PropertyUtils.describe(param_));
			System.out.println("return :"+jsonObj.toJSONString());
			if("1".equals(jsonObj.getString("result"))){
				BaseResult rs = MapUtils.toBean(jsonObj,resultClazz_);
				System.out.println("rs:"+rs);
			}
		}
}
