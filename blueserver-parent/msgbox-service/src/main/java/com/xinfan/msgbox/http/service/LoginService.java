package com.xinfan.msgbox.http.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserInfoParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserInfoResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserVipDao;

public class LoginService {
	@Autowired
	UserDao userDao;
	@Autowired
	UserBalanceDao userBalanceDao;
	@Autowired
	UserVipDao userVipDao;
	
	/**
	 * 登陆接口
	 * @param param
	 * @return
	 */
	public BaseResult login(RegisterParam param) {
		//TODO
		return null;
	}
	
	
	/**
	 * 登陆验证码获取接口
	 * @param param
	 * @return
	 */
	public ValidCodeResult getValidCode(BaseParam param) {
		//TODO
		return null;
	}
	
	/**
	 * 退出接口
	 * @param param
	 * @return
	 */
	public UserInfoResult logout(UserInfoParam param) {
		//TODO
		return null;
	}
	
	/**
	 * 修改密码
	 * @param param
	 * @return
	 */
	public UserInfoResult changePassWd(UserInfoParam param) {
		//TODO
		return null;
	}
	
	/**
	 * 修改密码验证码获取接口
	 * @param param
	 * @return
	 */
	public ValidCodeResult getChangePassWordValidCode(BaseParam param) {
		//TODO
		return null;
	}
}
