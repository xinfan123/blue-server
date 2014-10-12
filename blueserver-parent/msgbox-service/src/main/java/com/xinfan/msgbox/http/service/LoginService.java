package com.xinfan.msgbox.http.service;

import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.msgbox.common.security.Md5PwdFactory;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdAfterLoginParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdBeforeLoginParam;
import com.xinfan.msgbox.http.service.vo.param.LoginParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserInfoResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.entity.User;

public class LoginService extends BaseService{
	@Autowired
	UserDao userDao;
	
	private final String USER_LOGIN_VALID_CODE_SESSION_KEY = "user_login_valid_code_session";
	private final String USER_CHANGE_PASS_WORD_SESSION_KEY = "user_change_pass_word_session";
	

	
	/**
	 * 登陆接口
	 * @param param
	 * @return
	 */
	public BaseResult login(LoginParam param) {
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if(StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11){
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}
		if(StringUtils.isEmpty(param.getPasswd())){
			return new BaseResult().paramIllgal("密码为空或不合法");
		}
		if(StringUtils.isEmpty(param.getValidCode())){
			return new BaseResult().paramIllgal("验证码为空或不合法");
		}
		
		//先注释掉，影响流程
/*		if(!param.getValidCode().equals(ServiceContext.getRequest().getSession().getAttribute(USER_LOGIN_VALID_CODE_SESSION_KEY))){
			return new BaseResult().paramIllgal("验证码不匹配");
		}*/
		
		User user = userDao.selectByMobile(param.getMobile());
		if(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getPasswd()).equals(user.getPasswd())){
			ServiceContext.getRequest().getSession().setAttribute(USER_SESSION_KEY, user);
			return new BaseResult().success("登陆成功");
		}else{
			return new BaseResult().paramIllgal("密码错误");
		}
	}
	
	
	/**
	 * 登陆验证码获取接口
	 * @param param
	 * @return
	 */
	public ValidCodeResult getLoginValidCode(ValidCodeParam param) {
		ValidCodeResult rs = new ValidCodeResult();
		String random = new Random().nextInt(9999) + "";
		ServiceContext.getRequest().getSession().setAttribute(USER_LOGIN_VALID_CODE_SESSION_KEY,random);
		rs.setValidCode(random);
		return rs;
	}
	
	/**
	 * 退出接口
	 * @param param
	 * @return
	 */
	public BaseResult logout(BaseParam param) {
		ServiceContext.getRequest().getSession().removeAttribute(USER_SESSION_KEY);
		return new BaseResult().success("退出成功");
	}
	
	/**
	 * 登陆后修改密码
	 * @param param
	 * @return
	 */
	public BaseResult changePassWdAfterLogin(ChangePasswdAfterLoginParam param) {
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if(StringUtils.isEmpty(param.getOldPasswd())){
			return new BaseResult().paramIllgal("原密码不能为空");
		}
		if(StringUtils.isEmpty(param.getNewPasswd())){
			return new BaseResult().paramIllgal("新密码不能为空");
		}
		
		User user = getUserFromSession();
		if(!Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getOldPasswd()).equals(user.getPasswd())){
			return new BaseResult().paramIllgal("原密码错误");	
		}
		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getNewPasswd()));
		userDao.updateByPrimaryKey(user);
		return new BaseResult().success("密码修改成功");
	}
	
	/**
	 * 登陆前修改密码
	 * @param param
	 * @return
	 */
	public UserInfoResult changePassWdBeforeLogin(ChangePasswdBeforeLoginParam param) {
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if(StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11){
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}
		if(StringUtils.isEmpty(param.getOldPasswd())){
			return new BaseResult().paramIllgal("原密码不能为空");
		}
		if(StringUtils.isEmpty(param.getNewPasswd())){
			return new BaseResult().paramIllgal("新密码不能为空");
		}
		
		if(StringUtils.isEmpty(param.getValidCode())){
			return new BaseResult().paramIllgal("验证码不能为空");
		}
		if(!param.getValidCode().equals(ServiceContext.getRequest().getSession().getAttribute(USER_CHANGE_PASS_WORD_SESSION_KEY))){
			return new BaseResult().paramIllgal("验证码不能为空");
		}
		
		User user = userDao.selectByMobile(param.getMobile());
		if(user == null){
			return new BaseResult().paramIllgal("用户不存在错误");	
		}
		if(!Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getOldPasswd()).equals(user.getPasswd())){
			return new BaseResult().paramIllgal("原密码错误");	
		}
		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getNewPasswd()));
		userDao.updateByPrimaryKey(user);
		return new BaseResult().success("密码修改成功");
	}
	
	
	/**
	 * 修改密码验证码获取接口
	 * @param param
	 * @return
	 */
	public ValidCodeResult getChangePassWordValidCode(BaseParam param) {
		ValidCodeResult rs = new ValidCodeResult();
		String random = new Random().nextInt(9999) + "";
		ServiceContext.getRequest().getSession().setAttribute(USER_CHANGE_PASS_WORD_SESSION_KEY,random);
		rs.setValidCode(random);
		return rs;
	}
	
	

}
