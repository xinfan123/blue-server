package com.xinfan.msgbox.http.service.vo;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserInfoParam;
import com.xinfan.msgbox.http.service.vo.param.UserSetParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.UserInfoResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;

public enum FunIdConstants {
	GET_VALID_CODE_INTF("GET_VALID_CODE",ValidCodeParam.class,ValidCodeResult.class),
	USER_REGISTER_INTF("userRegister",RegisterParam.class,BaseResult.class),
	GET_USER_INFO("getUserInfo",UserInfoParam.class,UserInfoResult.class),
	SET_USERSET("setUserSet",UserSetParam.class,BaseResult.class)
	;
	
	private FunIdConstants(String funId, Class paramClass, Class resultClass) {
		this.funId = funId;
		this.paramClass = paramClass;
		this.resultClass = resultClass;
	}
	String funId;
	Class paramClass;
	Class resultClass;
	
	public String getFunId() {
		return funId;
	}
	public <T extends BaseParam> Class<T> getParamClass() {
		return paramClass;
	}
	public <T extends BaseResult> Class<T>  getResultClass() {
		return resultClass;
	}
	
	
	
}
