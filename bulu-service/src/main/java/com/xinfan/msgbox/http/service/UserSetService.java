package com.xinfan.msgbox.http.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.common.security.Md5PwdFactory;
import com.xinfan.msgbox.core.messagecache.MessageContext;
import com.xinfan.msgbox.core.util.TimeHelper;
import com.xinfan.msgbox.core.vo.CachedMessage;
import com.xinfan.msgbox.core.vo.Position;
import com.xinfan.msgbox.http.common.ServiceContext;
import com.xinfan.msgbox.http.service.util.BeanUtils;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserAvatarParam;
import com.xinfan.msgbox.http.service.vo.param.UserCIDParam;
import com.xinfan.msgbox.http.service.vo.param.UserGpsParam;
import com.xinfan.msgbox.http.service.vo.param.UserLinkmanParam;
import com.xinfan.msgbox.http.service.vo.param.UserParam;
import com.xinfan.msgbox.http.service.vo.param.UserReportMessageParam;
import com.xinfan.msgbox.http.service.vo.param.UserSentParam;
import com.xinfan.msgbox.http.service.vo.param.UserSetParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserAvatarResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;
import com.xinfan.msgbox.http.util.AvatarUtils;
import com.xinfan.msgbox.service.dao.MessageDao;
import com.xinfan.msgbox.service.dao.MessageReportedDao;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserBalanceHisDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserLinkmanDao;
import com.xinfan.msgbox.service.dao.UserSentDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.UserVipDao;
import com.xinfan.msgbox.service.dao.entity.Message;
import com.xinfan.msgbox.service.dao.entity.MessageReported;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserBalance;
import com.xinfan.msgbox.service.dao.entity.UserBalanceHis;
import com.xinfan.msgbox.service.dao.entity.UserExample;
import com.xinfan.msgbox.service.dao.entity.UserLinkman;
import com.xinfan.msgbox.service.dao.entity.UserSent;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.sms.SmsService;
import com.xinfan.msgbox.service.util.SeqFactory;

public class UserSetService extends BaseService {
	private static Logger logger = LoggerFactory.getLogger(UserSetService.class);

	@Autowired
	UserDao userDao;
	@Autowired
	UserBalanceDao userBalanceDao;
	@Autowired
	UserBalanceHisDao userBalanceHisDao;
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

	@Autowired
	SmsService smsService;

	/**
	 * 注册接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult addUserRegister(RegisterParam param) throws Exception {
		if (param == null) {
			return new BaseResult().paramIllgal("获取参数失败");
		}
		if (StringUtils.isEmpty(param.getMobile()) || param.getMobile().length() != 11) {
			return new BaseResult().paramIllgal("手机号为空或不合法");
		}
		if (StringUtils.isEmpty(param.getPasswd())) {
			return new BaseResult().paramIllgal("密码为空或不合法");
		}

		String sessionMobile = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_REGISTER_VALID_CODE_MOBILE));
		String sessionValidCode = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_REGISTER_VALID_CODE_SESSION_KEY));

		if (!param.getValidCode().equals(sessionValidCode)) {
			return new BaseResult().paramIllgal("验证码错误");
		}

		if (!param.getMobile().equals(sessionMobile)) {
			return new BaseResult().paramIllgal("验证手机号码不比配");
		}

		UserExample example = new UserExample();
		example.createCriteria().andMobileEqualTo(param.getMobile());
		List<User> userList = userDao.selectByExample(example);
		if (!CollectionUtils.isEmpty(userList)) {
			return new BaseResult().paramIllgal("手机号已被注册");
		}

		// 写用户
		User user = new User();
		user.setMobile(param.getMobile());
		user.setRegEarea(param.getRegEarea());
		user.setRegGpsx(param.getRegGpsx());
		user.setRegGpsy(param.getRegGpsy());
		user.setUserName(param.getUserName());

		user.setPasswd(Md5PwdFactory.getUserMd5PwdEncoder().encodePassword(param.getPasswd()));
		user.setRegTime(new Date());
		user.setUserState(1);
		user.setVip(0);
		user.setUserId(SeqFactory.getInstance().getSeqUser());

		user.setCid("");
		user.setCidTime(new Date());
		user.setLoginTime(new Date());
		user.setOnline(0);

		userDao.insertSelective(user);

		// 写用户设置
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

		// 写用户Banlance
		UserBalance balance = new UserBalance();
		balance.setUserId(user.getUserId());
		balance.setUserCredit(0);
		balance.setUserBalance(0);
		userBalanceDao.insertSelective(balance);

		UserBalanceHis balanceHis = new UserBalanceHis();
		BeanUtils.copyProperties(balanceHis, balance);
		userBalanceHisDao.insertSelective(balanceHis);

		return new BaseResult().success("注册成功");
	}

	public BaseResult updateUserCID(UserCIDParam param) throws Exception {

		if (param.getCid() == null || param.getCid().length() == 0) {
			return new BaseResult().success("cid参数为空");
		}

		User userSession = this.getUserFromSession();

		User user = userDao.selectByPrimaryKey(userSession.getUserId());

		User update = new User();
		update.setUserId(userSession.getUserId());
		update.setCid(param.getCid());
		update.setCidTime(new Date());

		userDao.updateByPrimaryKeySelective(update);

		return new BaseResult().success("更新成功");
	}

	/**
	 * 注册验证码获取接口
	 * 
	 * @param param
	 * @return
	 */
	public ValidCodeResult getUserRegisterValidCode(ValidCodeParam param) {

		if (param.getMobile() == null || param.getMobile().length() == 0) {
			return new BaseResult().paramIllgal("手机号码为空");
		}

		ValidCodeResult rs = new ValidCodeResult();
		String random = new Random().nextInt(9999) + "";

		ServiceContext.getRequest().getSession().setAttribute(BizConstants.USER_REGISTER_VALID_CODE_SESSION_KEY, random);
		ServiceContext.getRequest().getSession().setAttribute(BizConstants.USER_REGISTER_VALID_CODE_MOBILE, param.getMobile());

		rs.setValidCode(random);

		smsService.sendRegisterValidSms(param.getMobile(), random);
		// 发送注册短信验证码
		return rs;
	}

	public ValidCodeResult validUserRegisterValidCode(ValidCodeParam param) {

		if (param.getMobile() == null || param.getMobile().length() == 0) {
			return new ValidCodeResult().paramIllgal("手机号码为空");
		}

		if (param.getValidCode() == null || param.getValidCode().length() == 0) {
			return new ValidCodeResult().paramIllgal("验证码为空");
		}

		ValidCodeResult rs = new ValidCodeResult();

		String sessionMobile = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_REGISTER_VALID_CODE_MOBILE));
		String sessionValidCode = String.valueOf(ServiceContext.getRequest().getSession().getAttribute(BizConstants.USER_REGISTER_VALID_CODE_SESSION_KEY));

		if (!param.getValidCode().equals(sessionValidCode)) {
			return new ValidCodeResult().paramIllgal("验证码错误");
		}

		if (!param.getMobile().equals(sessionMobile)) {
			return new ValidCodeResult().paramIllgal("验证手机号码不比配");
		}

		UserExample example = new UserExample();
		example.createCriteria().andMobileEqualTo(param.getMobile());
		List<User> userList = userDao.selectByExample(example);
		if (!CollectionUtils.isEmpty(userList)) {
			return new ValidCodeResult().paramIllgal("手机号已被注册");
		}

		rs.setMsg("验证成功");

		return rs;

	}

	/**
	 * 设置用户设置接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult setUserSet(UserSetParam param) throws Exception {
		if (param == null) {
			return new BaseResult().paramIllgal("获取参数失败");
		}

		UserSet userSet = new UserSet();
		BeanUtils.copyProperties(userSet, param);

		Long userId = getUserFromSession().getUserId();
		UserSet u = userSetDao.selectByPrimaryKey(userId);
		if (u == null) {
			userSet.setUserId(userId);
			userSetDao.insertSelective(userSet);
		} else {
			userSet.setUserId(userId);
			userSet.setUpdatetime(new Date());
			userSetDao.updateByPrimaryKeySelective(userSet);
		}

		MessageContext.getInstance().updateUserProfile(userId, u);

		return new BaseResult().success("设置成功");
	}

	/**
	 * 增加用户联系人接口
	 * 
	 * @param param
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public BaseResult addUserLinkman(UserLinkmanParam param) throws Exception {
		if (param.getUserId() == null || param.getLinkUserId() == null) {
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}

		UserLinkman linkMan = new UserLinkman();
		BeanUtils.copyProperties(linkMan, param);

		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);

		if (l != null) {

			l.setLinkRemark(param.getLinkRemark());
			l.setCreateTime(new Date());
			userLinkmanDao.updateByPrimaryKeySelective(l);
			return new BaseResult().success("新增联系人成功");
		}

		linkMan.setCreateTime(new Date());

		userLinkmanDao.insertSelective(linkMan);
		return new BaseResult().success("新增联系人成功");
	}

	/**
	 * 修改用户联系人接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult updateUserLinkman(UserLinkmanParam param) throws Exception {
		if (param.getUserId() == null || param.getLinkUserId() == null) {
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}

		UserLinkman linkMan = new UserLinkman();
		linkMan.setUserId(param.getUserId());
		linkMan.setLinkUserId(param.getLinkUserId());
		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);
		if (l == null) {
			return new BaseResult().paramIllgal("联系用户ID不存在");
		}
		linkMan.setLinkRemark(param.getLinkRemark());
		userLinkmanDao.updateByPrimaryKeySelective(linkMan);
		return new BaseResult().success("修改联系人成功");
	}

	/**
	 * 删除用户联系人接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult deleteUserLinkman(UserLinkmanParam param) throws Exception {
		if (param.getUserId() == null || param.getLinkUserId() == null) {
			return new BaseResult().paramIllgal("用户ID或联系人用户ID不存在");
		}

		UserLinkman linkMan = new UserLinkman();
		BeanUtils.copyProperties(linkMan, param);
		UserLinkman l = userLinkmanDao.selectByPrimaryKey(linkMan);
		if (l == null) {
			return new BaseResult().paramIllgal("联系用户ID不存在");
		}

		userLinkmanDao.deleteByPrimaryKey(linkMan);
		return new BaseResult().success("删除联系人成功");
	}

	/**
	 * 设置用户关键语接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult setUserSent(UserSentParam param) throws Exception {
		if (param.getUserId() == null || param.getUserId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}
		if (StringUtils.isEmpty(param.getUserSent())) {
			return new BaseResult().paramIllgal("用户接收语句不存在");
		}

		User sessionUser = getUserFromSession();

		UserSent userSent = new UserSent();
		BeanUtils.copyProperties(userSent, param);

		userSent.setUserId(sessionUser.getUserId());
		userSentDao.insertSelective(userSent);

		User user = userDao.selectByPrimaryKey(sessionUser.getUserId());

		CachedMessage cm = new CachedMessage();
		cm.setUserId(user.getUserId());
		cm.setOriginalMsg(userSent.getUserSent());
		cm.setSrcPosition(new Position(user.getRegGpsx(), user.getRegGpsy(), user.getRegEarea()));
		cm.setTargetPosition(new Position(user.getRegGpsx(), user.getRegGpsy(), user.getRegEarea()));
		cm.setMessageId(userSent.getId());
		cm.setDeadTime(TimeHelper.getMaxDeadTime());

		MessageContext.getInstance().getInterestsCache().addMessage(cm);

		return new BaseResult().success("设置接收语成功");
	}

	/**
	 * 删除用户接收语接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult deleteUserSent(UserSentParam param) throws Exception {
		if (param.getId() == null || param.getId() == null) {
			return new BaseResult().paramIllgal("ID不存在");
		}

		long sentId = param.getId();

		UserSent sent = userSentDao.selectByPrimaryKey(sentId);
		if (sent == null) {
			return new BaseResult().success("删除用户接收语成功");
		}

		userSentDao.deleteByPrimaryKey(sentId);

		User user = this.userDao.selectByPrimaryKey(sent.getUserId());

		CachedMessage msg = new CachedMessage();
		msg.setMessageId(sentId);
		msg.setSrcPosition(new Position(user.getRegGpsx(), user.getRegGpsy(), user.getRegEarea()));
		MessageContext.getInstance().getInterestsCache().deleteMessage(msg);

		return new BaseResult().success("删除用户接收语成功");
	}

	/**
	 * 用户举报信息接口
	 * 
	 * @param param
	 * @return
	 */
	public BaseResult reportMessage(UserReportMessageParam param) throws Exception {

		if (param.getMsgId() == null) {
			return new BaseResult().paramIllgal("消息ID不存在");
		}
		if (param.getReportType() == null) {
			return new BaseResult().paramIllgal("举报类型不能为空");
		}
		Message message = messageDao.selectByPrimaryKey(param.getMsgId());
		if (message == null) {
			return new BaseResult().paramIllgal("消息不存在");
		}

		MessageReported report = new MessageReported();
		report.setBeReportedMsgId(param.getMsgId());

		report.setBeReportedUserId(message.getCreateUserId());
		report.setContext(param.getContext());
		report.setCreateTime(new Date());
		report.setDealStatus(0);
		report.setReportType(param.getReportType());
		report.setReportUserId(this.getUserFromSession().getUserId());

		Long reportedUserId = null;
		if (param.getUserId() == null) {
			User user = getUserFromSession();
			if (user != null) {
				reportedUserId = user.getUserId();
			}
		}
		report.setReportUserId(reportedUserId);
		messageReportedDao.insertSelective(report);
		return new BaseResult().success("感谢您的举报，我们将尽快进行核实处理！");
	}

	public BaseResult setUserNickname(UserParam param) throws Exception {

		if (param.getUserName() == null || param.getUserName().trim().length() == 0) {
			return new BaseResult().paramIllgal("昵称不能为空");
		}

		User session = getUserFromSession();

		User updateUser = new User();
		updateUser.setUserId(session.getUserId());
		updateUser.setUserName(param.getUserName());

		this.userDao.updateByPrimaryKeySelective(updateUser);

		return new BaseResult().success("修改成功");
	}

	public BaseResult setUserGps(UserGpsParam param) throws Exception {

		if (param.getLatitude() == null || param.getLatitude().trim().length() == 0) {
			return new BaseResult().paramIllgal("参数异常");
		}

		if (param.getLongitude() == null || param.getLongitude().trim().length() == 0) {
			return new BaseResult().paramIllgal("参数异常");
		}

		User session = getUserFromSession();

		User updateUser = new User();
		updateUser.setUserId(session.getUserId());

		updateUser.setRegGpsx(param.getLongitude());
		updateUser.setRegGpsy(param.getLatitude());
		updateUser.setRegEarea(param.getArea());

		userDao.updateByPrimaryKeySelective(updateUser);

		Position position = new Position(updateUser.getRegGpsx(), updateUser.getRegGpsy(), updateUser.getRegEarea());
		MessageContext.getInstance().updateUserPosition(updateUser.getUserId(), position);

		return new BaseResult().success("修改成功");
	}

	public UserAvatarResult setUserAvatar(UserAvatarParam param) throws Exception {

		UserAvatarResult result = new UserAvatarResult();

		if (param.getAvatar() != null && param.getAvatar().length() > 100) {

			User session = getUserFromSession();

			String name = AvatarUtils.save(ServiceContext.getRequest(), param.getAvatar());

			User user = new User();
			user.setUserId(session.getUserId());
			user.setAvatar(name);

			this.userDao.updateByPrimaryKeySelective(user);

			result.setAvatar(name);
		}

		result.setResult(1);

		return result;
	}

	public UserAvatarResult getUserAvatar(UserAvatarParam param) throws Exception {

		UserAvatarResult result = new UserAvatarResult();

		String name = param.getAvatar();
		String avatar = AvatarUtils.get(ServiceContext.getRequest(), name);

		result.setAvatar(avatar);

		return result;

	}
}
