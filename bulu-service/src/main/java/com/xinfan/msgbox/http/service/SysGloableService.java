package com.xinfan.msgbox.http.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.ClientVersionParam;
import com.xinfan.msgbox.http.service.vo.result.ClientVersionListResult;
import com.xinfan.msgbox.http.service.vo.result.ClientVersionResult;
import com.xinfan.msgbox.http.service.vo.result.ConfigListResult;
import com.xinfan.msgbox.http.service.vo.result.ConfigResult;
import com.xinfan.msgbox.service.dao.ClientVersionDao;
import com.xinfan.msgbox.service.dao.ConfigDao;
import com.xinfan.msgbox.service.dao.entity.ClientVersion;
import com.xinfan.msgbox.service.dao.entity.ClientVersionExample;
import com.xinfan.msgbox.service.dao.entity.ClientVersionExample.Criteria;
import com.xinfan.msgbox.service.dao.entity.Config;
import com.xinfan.msgbox.service.dao.entity.ConfigExample;

public class SysGloableService {
	@Autowired
	ConfigDao configDao;
	@Autowired
	ClientVersionDao clientVersionDao;

	/**
	 * 获取系统配置接口
	 */
	public ConfigListResult getConfigList(BaseParam param) throws Exception {
		ConfigExample example = new ConfigExample();
		List<Config> list = configDao.selectByExample(example);

		List<ConfigResult> rsList = new ArrayList<ConfigResult>();
		if (!CollectionUtils.isEmpty(list)) {
			for (Config config : list) {
				ConfigResult cr = new ConfigResult();
				PropertyUtils.copyProperties(cr, config);
				rsList.add(cr);
			}
		}

		ConfigListResult rs = new ConfigListResult();
		rs.setList(rsList);
		return rs;
	}

	/**
	 * 获取版本信息接口
	 * 
	 * @param param
	 * @return
	 */
	public ClientVersionResult getClientVersion(ClientVersionParam param) throws Exception {
		if (StringUtils.isEmpty(param.getClientCode())) {
			return new ClientVersionListResult().paramIllgal("客户端编号不能为空");
		}

		ClientVersionResult result = new ClientVersionResult();

		ClientVersionExample example = new ClientVersionExample();
		Criteria c = example.createCriteria().andClientCodeEqualTo(param.getClientCode()).andIsNewestEqualTo("1");
		c.andVersionGreaterThan(param.getCurrentVersion());
		example.setOrderByClause("version desc ");

		List<ClientVersion> list = clientVersionDao.selectByExample(example);

		// APP都全量升级，不需要增量升级
		if (!CollectionUtils.isEmpty(list)) {
			ClientVersion version = list.get(0);
			result.setCode(version.getClientCode());
			result.setCurrentVersion(version.getVersion());
			result.setFullDownloadUrl(version.getFullDownloadUrl());
			result.setIntroduceUrl(version.getIntroduceUrl());

			result.setMsg("查询成功");
		} else {
			result.setMsg("查询失败");
		}

		return result;
	}

}
