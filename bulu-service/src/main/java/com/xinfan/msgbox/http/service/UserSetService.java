package com.xinfan.msgbox.http.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.common.security.Md5PwdFactory;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserLinkmanParam;
import com.xinfan.msgbox.http.service.vo.param.UserParam;
import com.xinfan.msgbox.http.service.vo.param.UserReportMessageParam;
import com.xinfan.msgbox.http.service.vo.param.UserSentParam;
import com.xinfan.msgbox.http.service.vo.param.UserSetParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.MessageReportedDao;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserLinkmanDao;
import com.xinfan.msgbox.service.dao.UserSentDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.UserVipDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageReported;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserBalance;
import com.xinfan.msgbox.service.dao.entity.UserExample;
import com.xinfan.msgbox.service.dao.entity.UserLinkman;
import com.xinfan.msgbox.service.dao.entity.UserSent;
import com.xinfan.msgbox.service.dao.entity.UserSet;

public class UserSetService extends BaseService{
	@Autowired
	UserDao userDao;
	@Autowired
	UserBalanceDao userBalanceDao;
	@Autowired
	UserVipDao userVipDao;
	@Autowired
	UserSetDao userSetDao;
	@Autowired
	UserLinkmanDao userLinkmanDao;
	@Autowired
	UserSentDao userSentDao;
	@Autowired
	MessageReportedDao messageReportedDao;
	@Autowired
	MessageDao messageDao;
	/**
	 * 注册接口
	 * @param param
	 * @return
	 */
	public BaseResult userRegister(RegisterParam param) {
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if(StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11){
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}
		if(StringUtils.isEmpty(param.getPasswd())){
			return new BaseResult().paramIllgal("密码为空或不合法");
		}
		
		if(StringUtils.isEmpty(param.getValidCode()) || !param.getValidCode().equals(ServiceContext.getRequest().getSession().getAttribute(USER_REGISTER_VALID_CODE_SESSION_KEY))){
			return new BaseResult().paramIllgal("验证码为空或不匹配");
		}
		UserExample example = new UserExample();
		example.createCriteria().andMobileEqualTo(param.getMobile());
		List<User> userList =  userDao.selectByExample(example);
		if(!CollectionUtils.isEmpty(userList)){
			return new BaseResult().paramIllgal("手机号已被注册");
		}
		
		//写用户
		User user = new User();
		user.setMobile(param.getMobile());
		user.setRegEarea(param.getRegEarea());
		user.setRegGpsx(param.getRegGpsx());
		user.setRegGpsy(param.getRegGpsy());
		
		
		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getPasswd()));
		user.setRegTime(new Date());
		user.setUserState(1);
		user.setVip(0);
		userDao.insertSelective(user);
		
		//写用户设置
		UserSet userSet = new UserSet();
		userSet.setUserId(user.getUserId());
		userSet.setMaxCount(20);
		userSet.setMinAmmount(0);
		userSet.setMinCredit(10);
		userSet.setVoice(1);
		userSet.setNewMsgNotify(1);
		userSet.setVibrate(1);
		userSet.setSimilarLevel(3);
		userSetDao.insertSelective(userSet);
		
		//写用户Banlance
		UserBalance balance = new UserBalance();
		balance.setUserId(user.getUserId());
		balance.setUserCredit(0);
		balance.setUserBalance(0);
		userBalanceDao.insertSelective(balance);
		
		return new BaseResult().success("注册成功");
	}
	
	
	
	/**
	 * 注册接口
	 * @param param
	 * @return
	 */
	public BaseResult updateUser(UserParam param) {
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		
		User user = getUserFromSession();
		
		boolean toUpdate = false;
		if(StringUtils.isNotEmpty(param.getMobile())){
			User u = userDao.selectByMobile(param.getMobile());
			if(u == null){
				user.setMobile(param.getMobile());
				toUpdate = true;
			}
		}
		if(StringUtils.isNotEmpty(param.getUserName())){
			user.setUserName(param.getUserName());
			toUpdate = true;
		}
		
		if(toUpdate){
			userDao.updateByPrimaryKey(user);
		}
		
		return new BaseResult().success("修改成功");
	}
	
	
	private static final String USER_REGISTER_VALID_CODE_SESSION_KEY ="user_register_valid_code_session";
	
	/**
	 * 注册验证码获取接口
	 * @param param
	 * @return
	 */
	public ValidCodeResult getUserRegisterValidCode(ValidCodeParam param) {
		ValidCodeResult rs = new ValidCodeResult();
		String random = new Random().nextInt(9999) + "";
		ServiceContext.getRequest().getSession().setAttribute(USER_REGISTER_VALID_CODE_SESSION_KEY,random);
		rs.setValidCode(random);
		return rs;
	}
	
	
	
	/**
	 * 设置用户设置接口
	 * @param param
	 * @return
	 */
	public BaseResult setUserSet(UserSetParam param) throws Exception{
		if(param == null){
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if(param.getUserId() == null || param.getUserId() <= 0){
			return new BaseResult().paramIllgal("用户ID不存在");
		}
		
		UserSet userSet = new UserSet();
		PropertyUtils.copyProperties(userSet, param);
		
		UserSet u = userSetDao.selectByPrimaryKey(userSet.getUserId());
		if(u == null){
			userSetDao.insertSelective(u);
		}else{
			userSet.setUpdatetime(new Date());
			userSetDao.updateByPrimaryKey(userSet);
		}
		return new BaseResult().success("设置成功");
	}
	
	/**
	 * 增加用户联系人接口
	 * @param param
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public BaseResult addUserLinkman(UserLinkmanParam param) throws Exception {
		if(param.getUserId() == null || param.getLinkUserId() == null){
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}
		
		UserLinkman linkMan = new UserLinkman();
		BeanUtils.copyProperties(linkMan, param);
		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);
		if(l != null){
			return new BaseResult().paramIllgal("联系用户ID已存在");
		}
		linkMan.setCreateTime(new Date());
		userLinkmanDao.insertSelective(linkMan);
		return new BaseResult().success("新增联系人成功");
	}
	
	/**
	 * 修改用户联系人接口
	 * @param param
	 * @return
	 */
	public BaseResult updateUserLinkman(UserLinkmanParam param) throws Exception{
		if(param.getUserId() == null || param.getLinkUserId() == null){
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}
		
		UserLinkman linkMan = new UserLinkman();
		BeanUtils.copyProperties(linkMan, param);
		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);
		if(l == null){
			return new BaseResult().paramIllgal("联系用户ID不存在");
		}
		BeanUtils.copyProperties(linkMan, param);
		userLinkmanDao.updateByPrimaryKey(linkMan);
		return new BaseResult().success("修改联系人成功");
	}
	
	

	/**
	 * 删除用户联系人接口
	 * @param param
	 * @return
	 */
	public BaseResult deleteUserLinkman(UserLinkmanParam param) throws Exception {
		if(param.getUserId() == null || param.getLinkUserId() == null){
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}
		
		UserLinkman linkMan = new UserLinkman();
		BeanUtils.copyProperties(linkMan, param);
		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);
		if(l == null){
			return new BaseResult().paramIllgal("联系用户ID不存在");
		}
		
		userLinkmanDao.deleteByPrimaryKey(linkMan);
		return new BaseResult().success("删除联系人成功");
	}
	
	/**
	 * 设置用户关键语接口
	 * @param param
	 * @return
	 */
	public BaseResult setUserSent(UserSentParam param) throws Exception{
		if(param.getUserId() == null || param.getUserId() == null){
			return new BaseResult().paramIllgal("用户ID不存在");
		}
		if(StringUtils.isEmpty(param.getUserSent())){
			return new BaseResult().paramIllgal("用户接收语句不存在");
		}
		UserSent userSent = new UserSent();
		BeanUtils.copyProperties(userSent, param);
		userSentDao.insertSelective(userSent);
		return new BaseResult().success("设置接收语成功");
	}
	
	/**
	 * 删除用户接收语接口
	 * @param param
	 * @return
	 */
	public BaseResult deleteUserSent(UserSentParam param) throws Exception{
		if(param.getId() == null || param.getId() == null){
			return new BaseResult().paramIllgal("ID不存在");
		}
		
		UserSent userSent = new UserSent();
		BeanUtils.copyProperties(userSent, param);
		userSentDao.deleteByPrimaryKey(userSent);
		return new BaseResult().success("删除用户接收语成功");
	}
	
	/**
	 * 用户举报信息接口
	 * @param param
	 * @return
	 */
	public BaseResult reportMessage(UserReportMessageParam param) throws Exception{
		if(param.getMsgId() == null){
			return new BaseResult().paramIllgal("消息ID不存在");
		}
		if(param.getReportType() == null){
			return new BaseResult().paramIllgal("举报类型不能为空");
		}
		Message message = messageDao.selectByPrimaryKey(param.getMsgId());
		if(message == null){
			return new BaseResult().paramIllgal("消息不存在");
		}
		
		MessageReported report = new MessageReported();
		report.setBeReportedMsgId(param.getMsgId());
		
		report.setBeReportedUserId(message.getCreateUserId());
		report.setContext(param.getContext());
		report.setCreateTime(new Date());
		report.setDealStatus(0);
		report.setReportType(param.getReportType());
		
		Long reportedUserId = null;
		if(param.getUserId() == null){
			User user = getUserFromSession();
			if(user != null){
				reportedUserId = user.getUserId();
			}
		}
		report.setReportUserId(reportedUserId);
		messageReportedDao.insertSelective(report);
		return new BaseResult().success("举报成功");
	}
}
