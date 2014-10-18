package com.xinfan.msgbox.service.sms;

import com.xinfan.msgbox.common.BaseResult;

public interface SmsService {
	/**
	 * 发送注册短信验证码
	 * @param mobile
	 * @param validCode
	 * @return
	 */
	public BaseResult<String> sendRegisterValidSms(String mobile,String validCode);
	/**
	 * 发送修改密码短信验证码
	 * @param mobile
	 * @param validCode
	 * @return
	 */
	public BaseResult<String> sendChangePwdValidSms(String mobile,String validCode);
}
