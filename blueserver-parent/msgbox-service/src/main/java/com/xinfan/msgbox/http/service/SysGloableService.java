package com.xinfan.msgbox.http.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.xinfan.msgbox.http.service.vo.param.ClientVersionParam;
import com.xinfan.msgbox.http.service.vo.param.UserInfoParam;
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
	public ConfigListResult getConfigList(UserInfoParam param)throws Exception {
		ConfigExample example = new ConfigExample();
		List<Config> list = configDao.selectByExample(example);
		
		List<ConfigResult> rsList = new ArrayList<ConfigResult>();
		if(!CollectionUtils.isEmpty(list)){
			for(Config config : list){
				ConfigResult cr  = new ConfigResult();
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
	 * @param param
	 * @return
	 */
	public ClientVersionListResult getClientVersionList(ClientVersionParam param) throws Exception{
		if(StringUtils.isEmpty(param.getClientCode())){
			return new ClientVersionListResult().paramIllgal("客户端编号不能为空");
		}
		ClientVersionExample example = new ClientVersionExample();
		Criteria c = example.createCriteria().andClientCodeEqualTo(param.getClientCode());
		if(StringUtils.isNotEmpty(param.getCurrentVersion())){
			c.andVersionGreaterThan(param.getCurrentVersion());
		}
		
		List<ClientVersion> list =  clientVersionDao.selectByExample(example);
		ClientVersionListResult rs = new ClientVersionListResult();
		
		List<ClientVersionResult> rsList = new ArrayList<ClientVersionResult>();
		if(!CollectionUtils.isEmpty(list)){
			for(ClientVersion cv : list){
				ClientVersionResult cvr = new ClientVersionResult();
				PropertyUtils.copyProperties(cvr, cv);
				rsList.add(cvr);
			}
			rs.setList(rsList);
			rs.setMsg("有需要更新的版本，一共"+list.size()+"个");
		}else{
			rs.setMsg("没有需要更新的版本");
		}
		return rs;
	}
	
}
