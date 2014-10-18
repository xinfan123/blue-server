package com.xinfan.msgbox.service.sms.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.xinfan.msgbox.common.BaseResult;
import com.xinfan.msgbox.service.sms.SmsService;
import com.xinfan.msgbox.service.sms.impl.bean.YunpianSmsBean;
/**
 * 云片短信http接口
 * @author jiangyx
 * @since 2013-12-1
 */
public class YunPianSmsServiceImpl implements SmsService{
	private static final Logger logger = LoggerFactory.getLogger(YunpianSmsBean.class);
	
	@Override
	public BaseResult<String> sendRegisterValidSms(String mobile,String validCode) {
		try {
			String rs = YunpianSmsBean.tplSendSms(YunpianSmsBean.REGISTER_TPL_ID, "#code#="+validCode, mobile);
			JSONObject json = JSONObject.parseObject(rs);
			if(json != null && "0".equals(json.getString("code"))){
				return new BaseResult<String>().putMessage("发送成功").putResult(0);
			}else{
				return  new BaseResult<String>().putMessage("发送失败,yunpiansms return:"+rs).putResult(2); 
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("发送注册短信异常",e);
			return new BaseResult<String>().putMessage("系统异常:"+e.getMessage()).putResult(1);
		}
	}
	
	@Override
	public BaseResult<String> sendChangePwdValidSms(String mobile,String validCode) {
		try{
			String rs = YunpianSmsBean.tplSendSms(YunpianSmsBean.CHANGE_PASSWORD_TPL_ID, "#code#="+validCode, mobile);
			JSONObject json = JSONObject.parseObject(rs);
			if(json != null && "0".equals(json.getString("code"))){
				return new BaseResult<String>().putMessage("发送成功").putResult(0);
			}else{
				return  new BaseResult<String>().putMessage("发送失败,yunpiansms return:"+rs).putResult(2); 
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("发送修改密码短信异常",e);
			return new BaseResult<String>().putMessage("系统异常:"+e.getMessage()).putResult(1);
		}
	}
}
