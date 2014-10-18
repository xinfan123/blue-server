package com.xinfan.msgbox.http.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.UserLinkmanListParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserLinkmanListResult;
import com.xinfan.msgbox.http.service.vo.result.UserLinkmanResult;
import com.xinfan.msgbox.http.service.vo.result.UserResult;
import com.xinfan.msgbox.http.service.vo.result.UserSentListResult;
import com.xinfan.msgbox.http.service.vo.result.UserSentResult;
import com.xinfan.msgbox.http.service.vo.result.UserSetResult;
import com.xinfan.msgbox.http.util.PageUtils;
import com.xinfan.msgbox.service.dao.UserBalanceDao;
import com.xinfan.msgbox.service.dao.UserDao;
import com.xinfan.msgbox.service.dao.UserLinkmanDao;
import com.xinfan.msgbox.service.dao.UserSentDao;
import com.xinfan.msgbox.service.dao.UserSetDao;
import com.xinfan.msgbox.service.dao.UserVipDao;
import com.xinfan.msgbox.service.dao.entity.User;
import com.xinfan.msgbox.service.dao.entity.UserBalance;
import com.xinfan.msgbox.service.dao.entity.UserLinkman;
import com.xinfan.msgbox.service.dao.entity.UserSent;
import com.xinfan.msgbox.service.dao.entity.UserSentExample;
import com.xinfan.msgbox.service.dao.entity.UserSet;
import com.xinfan.msgbox.service.dao.entity.UserVip;

public class UserGetService extends BaseService{
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

	/**
	 * 用户获取接口
	 */
	public UserResult getUser(BaseParam param) throws Exception {
		if (param.getUserId() == null || param.getUserId() == null) {
			return new UserResult().paramIllgal("用户ID不能为空");
		}

		UserResult rs = new UserResult();
		User user = userDao.selectByPrimaryKey(param.getUserId());
		if (user != null) {
			BeanUtils.copyProperties(rs, user);
		} else {
			return new UserResult().paramIllgal("用户不存在");
		}

		UserVip vip = userVipDao.selectByPrimaryKey(param.getUserId());
		if (vip != null) {
			BeanUtils.copyProperties(rs, vip);
		}

		UserBalance balance = userBalanceDao.selectByPrimaryKey(param.getUserId());
		if (balance != null) {
			BeanUtils.copyProperties(rs, balance);
		}
		rs.setMsg("获取用户信息成功");
		return rs;
	}

	/**
	 * 用户联系人获取接口
	 */
	public UserLinkmanListResult getUserLinkmanList(UserLinkmanListParam param) throws Exception {
		if (param.getUserId() == null || param.getUserId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}

		Map<String, String> map = BeanUtils.describe(param);

		map.put("orderBy", "create_time");

		PageUtils.calCurrentRow(map);

		List<UserLinkman> list = userLinkmanDao.selectListForHttpService(map);

		List<UserLinkmanResult> rsList = new ArrayList<UserLinkmanResult>();
		if (!CollectionUtils.isEmpty(list)) {
			for (UserLinkman linkMan : list) {
				UserLinkmanResult rs = new UserLinkmanResult();
				BeanUtils.copyProperties(rs, linkMan);
				if (StringUtils.isEmpty(linkMan.getLinkRemark())) {
					User user = userDao.selectByPrimaryKey(linkMan.getUserId());
					if (user != null) {
						rs.setUserName(user.getUserName());
					}
				}
				rsList.add(rs);
			}
		}
		UserLinkmanListResult rs = new UserLinkmanListResult();
		rs.setList(rsList);
		rs.setResult(BaseResult.SUCCESS);
		return rs;
	}

	/**
	 * 获取用户设置接口
	 * 
	 * @param param
	 * @return
	 */
	public UserSetResult getUserSet(BaseParam param) throws Exception {
		UserSet userSet = userSetDao.selectByPrimaryKey(getUserFromSession().getUserId());
		if (userSet == null) {
			return new BaseResult().paramIllgal("用户设置不存在");
		}
		UserSetResult rs = new UserSetResult();
		BeanUtils.copyProperties(rs, userSet);
		rs.setResult(BaseResult.SUCCESS);
		return rs;
	}

	/**
	 * 获取用户设置关键语接口
	 * 
	 * @param param
	 * @return
	 */
	public UserSentListResult getUserSentList(BaseParam param) throws Exception {
		if (param.getUserId() == null || param.getUserId() == null) {
			return new BaseResult().paramIllgal("用户ID不存在");
		}
		UserSentExample example = new UserSentExample();
		example.createCriteria().andUserIdEqualTo(param.getUserId());
		List<UserSent> list = userSentDao.selectByExample(example);

		List<UserSentResult> rsList = new ArrayList<UserSentResult>();
		if (!CollectionUtils.isEmpty(list)) {
			for (UserSent us : list) {
				UserSentResult rs = new UserSentResult();
				BeanUtils.copyProperties(rs, us);
				rsList.add(rs);
			}

		}
		UserSentListResult rs = new UserSentListResult();
		rs.setList(rsList);
		rs.setResult(BaseResult.SUCCESS);
		return rs;
	}

}
