package com.xinfan.msgbox.http.service;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.msgbox.common.security.Md5PwdFactory;
import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdAfterLoginParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdBeforeLoginParam;
import com.xinfan.msgbox.http.service.vo.param.LoginParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.LoginResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserBalance;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.sms.SmsService;

public class LoginService extends BaseService {

	private static Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	UserDao userDao;

	@Autowired
	UserSetDao userSetDao;

	@Autowired
	UserBalanceDao userBalanceDao;

	@Autowired
	SmsService smsService;

	/**
	 * 登陆接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult login(LoginParam param) {
		if (param == null) {
			return new LoginResult().paramIllgal("获取参数失败");
		}
		if (StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11) {
			return new LoginResult().paramIllgal("手机号为空或不合法");
		}
		if (StringUtils.isEmpty(param.getPasswd())) {
			return new LoginResult().paramIllgal("密码为空或不合法");
		}

		// 先注释掉，影响流程

		// if(!param.getValidCode().equals(ServiceContext.getRequest().getSession().getAttribute(USER_LOGIN_VALID_CODE_SESSION_KEY))){
		// return new BaseResult().paramIllgal("验证码不匹配");
		// }

		User user = userDao.selectByMobile(param.getMobile());
		if (user == null) {
			return new LoginResult().paramIllgal("用户不存在");
		}

		if (!param.getPasswd().equals(user.getPasswd())) {
			return new LoginResult().paramIllgal("密码不正确");
		}

		ServiceContext.getRequest().getSession().setAttribute(USER_SESSION_KEY, user);

		LoginResult login = new LoginResult().success("登陆成功");

		login.setUserId(user.getUserId());
		login.setUserName(user.getUserName());
		login.setMobile(user.getMobile());
		login.setRegTime(user.getRegTime());
		login.setRegEarea(user.getRegEarea());
		login.setAvatar(user.getAvatar());

		UserBalance userBalance = userBalanceDao.selectByPrimaryKey(user.getUserId());
		if (userBalance != null) {
			login.setCredit(userBalance.getUserCredit());
		}

		// 更新用户登录信息
		User updateUser = new User();
		updateUser.setUserId(user.getUserId());
		updateUser.setLoginTime(new Date());
		updateUser.setOnline(1);

		this.userDao.updateByPrimaryKeySelective(updateUser);

		UserSet userSet = userSetDao.selectByPrimaryKey(updateUser.getUserId());
		MessageContext.getInstance().addUser(updateUser, userSet);

		return login;
	}

	/**
	 * 退出接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult logout(BaseParam param) {
		ServiceContext.getRequest().getSession().removeAttribute(USER_SESSION_KEY);

		Long userid = param.getUserId();

		logger.info("userid : " + userid + " is logout ");

		return new BaseResult().success("退出成功");
	}

	/**
	 * 登陆后修改密码
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult changePassWdAfterLogin(ChangePasswdAfterLoginParam param) {
		if (param == null) {
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if (StringUtils.isEmpty(param.getOldPasswd())) {
			return new BaseResult().paramIllgal("原密码不能为空");
		}
		if (StringUtils.isEmpty(param.getNewPasswd())) {
			return new BaseResult().paramIllgal("新密码不能为空");
		}

		User user = getUserFromSession();

		if (!Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getOldPasswd()).equals(user.getPasswd())) {
			return new BaseResult().paramIllgal("原密码错误");
		}

		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getNewPasswd()));
		userDao.updateByPrimaryKeySelective(user);
		return new BaseResult().success("密码修改成功");
	}

	/**
	 * 登陆前修改密码
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult changePassWdBeforeLogin(ChangePasswdBeforeLoginParam param) {
		if (param == null) {
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if (StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11) {
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}
		if (StringUtils.isEmpty(param.getNewPasswd())) {
			return new BaseResult().paramIllgal("新密码不能为空");
		}

		if (StringUtils.isEmpty(param.getValidCode())) {
			return new BaseResult().paramIllgal("验证码不能为空");
		}

		String sessionMobile = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_CHANGE_PASS_WORD_MOBILE));
		String sessionValidCode = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_CHANGE_PASS_WORD_VILIDCODE_SESSION_KEY));

		if (!param.getValidCode().equals(sessionValidCode)) {
			return new BaseResult().paramIllgal("验证码错误");
		}

		if (!param.getMobile().equals(sessionMobile)) {
			return new BaseResult().paramIllgal("验证手机号码不比配");
		}

		User user = userDao.selectByMobile(param.getMobile());
		if (user == null) {
			return new BaseResult().paramIllgal("用户不存在");
		}
		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getNewPasswd()));
		userDao.updateByPrimaryKeySelective(user);
		return new BaseResult().success("密码修改成功");
	}

	public BaseResult validPwdcodeBeforeLogin(ChangePasswdBeforeLoginParam param) {

		if (param == null) {
			return new BaseResult().paramIllgal("获取参数失败");
		}

		if (StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11) {
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}

		User user = userDao.selectByMobile(param.getMobile());
		if (user == null) {
			return new BaseResult().paramIllgal("此手机号尚未注册");
		}

		String sessionMobile = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_CHANGE_PASS_WORD_MOBILE));
		String sessionValidCode = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_CHANGE_PASS_WORD_VILIDCODE_SESSION_KEY));

		if (!param.getValidCode().equals(sessionValidCode)) {
			return new BaseResult().paramIllgal("验证码错误");
		}

		if (!param.getMobile().equals(sessionMobile)) {
			return new BaseResult().paramIllgal("验证手机号码不比配");
		}

		return new BaseResult().success("验证成功");
	}

	/**
	 * 修改密码验证码获取接口
	 * 
	 * @param param
	 * @return
	 */
	public ValidCodeResult getChangePassWordValidCode(ValidCodeParam param) {

		if (param.getMobile() == null || param.getMobile().length() == 0) {
			return new BaseResult().paramIllgal("手机号码不能空");
		}

		ValidCodeResult rs = new ValidCodeResult();
		String random = new Random().nextInt(9999) + "";
		ServiceContext.getRequest().getSession().setAttribute(BizConstants.USER_CHANGE_PASS_WORD_VILIDCODE_SESSION_KEY, random);
		ServiceContext.getRequest().getSession().setAttribute(BizConstants.USER_CHANGE_PASS_WORD_MOBILE, param.getMobile());
		rs.setValidCode(random);

		// 发送短信代码
		smsService.sendChangePwdValidSms(param.getMobile(), random);
		return rs;
	}

}
