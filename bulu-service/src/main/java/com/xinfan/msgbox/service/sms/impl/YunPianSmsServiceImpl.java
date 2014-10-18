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
	public void sendRegisterValidSms(final String mobile,final String validCode) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String rs = YunpianSmsBean.tplSendSms(YunpianSmsBean.REGISTER_TPL_ID, "#code#="+validCode, mobile);
					JSONObject json = JSONObject.parseObject(rs);
					if(json != null && "0".equals(json.getString("code"))){
						logger.info("发送注册验证码成功,"+rs);
					}else{
						logger.error("发送注册验证码失败,"+rs);
					}
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("发送注册短信异常",e);
				}
			}
		}).start();
		
	}
	
	@Override
	public void sendChangePwdValidSms(final String mobile,final String validCode) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					String rs = YunpianSmsBean.tplSendSms(YunpianSmsBean.CHANGE_PASSWORD_TPL_ID, "#code#="+validCode, mobile);
					JSONObject json = JSONObject.parseObject(rs);
					if(json != null && "0".equals(json.getString("code"))){
						logger.info("发送修改密码验证码成功,"+rs);
					}else{
						logger.error("发送修改密码验证码失败,"+rs);
					}
				} catch (IOException e) {
					e.printStackTrace();
					logger.error("发送修改密码短信异常",e);
				}
			}
		});
	}
}
