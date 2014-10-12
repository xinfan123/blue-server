package com.xinfan.msgbox.http.service.vo;

import com.xinfan.msgbox.http.service.vo.param.BaseParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdAfterLoginParam;
import com.xinfan.msgbox.http.service.vo.param.ChangePasswdBeforeLoginParam;
import com.xinfan.msgbox.http.service.vo.param.LoginParam;
import com.xinfan.msgbox.http.service.vo.param.MessageParam;
import com.xinfan.msgbox.http.service.vo.param.RegisterParam;
import com.xinfan.msgbox.http.service.vo.param.UserLinkmanListParam;
import com.xinfan.msgbox.http.service.vo.param.UserLinkmanParam;
import com.xinfan.msgbox.http.service.vo.param.UserMessageListParam;
import com.xinfan.msgbox.http.service.vo.param.UserReportMessageParam;
import com.xinfan.msgbox.http.service.vo.param.UserSentParam;
import com.xinfan.msgbox.http.service.vo.param.UserSetParam;
import com.xinfan.msgbox.http.service.vo.param.ValidCodeParam;
import com.xinfan.msgbox.http.service.vo.result.BaseResult;
import com.xinfan.msgbox.http.service.vo.result.ClientVersionListResult;
import com.xinfan.msgbox.http.service.vo.result.ConfigListResult;
import com.xinfan.msgbox.http.service.vo.result.LoginResult;
import com.xinfan.msgbox.http.service.vo.result.MessageListResult;
import com.xinfan.msgbox.http.service.vo.result.MessageResult;
import com.xinfan.msgbox.http.service.vo.result.UserLinkmanListResult;
import com.xinfan.msgbox.http.service.vo.result.UserResult;
import com.xinfan.msgbox.http.service.vo.result.UserSentListResult;
import com.xinfan.msgbox.http.service.vo.result.UserSetResult;
import com.xinfan.msgbox.http.service.vo.result.ValidCodeResult;

public enum FunIdConstants {
	/*************用户设置相关部分*************/
	//获取用户注册验证码
	GET_USERREGISTER_VALIDCODE("getUserRegisterValidCode",ValidCodeParam.class,ValidCodeResult.class),
	//用户注册
	USER_REGISTER("userRegister",RegisterParam.class,BaseResult.class),
	//设置用户设置
	SET_USERSET("setUserSet",UserSetParam.class,BaseResult.class),
	//增加用户联系人
	ADD_USER_LINKMAN("addUserLinkman",UserLinkmanParam.class,BaseResult.class),
	//修改用户联系人
	UPDATE_USER_LINKMAN("updateUserLinkman",UserLinkmanParam.class,BaseResult.class),
	//删除用户联系人
	DELETE_USER_LINKMAN("deleteUserLinkman",UserLinkmanParam.class,BaseResult.class),
	//设置用户主题
	SET_USER_SENT("setUserSent",UserSentParam.class,BaseResult.class),
	//删除用户主题
	DELETE_USER_SENT("deleteUserSent",UserSentParam.class,BaseResult.class),
	//用户举报信息
	REPORT_MESSAGE("reportMessage",UserReportMessageParam.class,BaseResult.class),
	
	/*************用户信息获取相关部分*************/
	//获取用户联系人列表
	GET_USER_LINKMAN_LIST("getUserLinkmanList",UserLinkmanListParam.class,UserLinkmanListResult.class),
	//获取用户设置
	GET_USERSET("getUserSet",BaseParam.class,UserSetResult.class),
	//获取用户主题列表
	GET_USER_SENT_LIST("BaseParam",BaseParam.class,UserSentListResult.class),
	//获取用户
	GET_USER("getUser",BaseParam.class,UserResult.class),
	
	/*************用户登陆相关部分*************/
	//登陆
	LOGIN("login",LoginParam.class,LoginResult.class),
	//获取登陆验证码
	GET_LOGIN_VALID_CODE("getLoginValidCode",ValidCodeParam.class,ValidCodeResult.class),
	//退出
	LOGOUT("logout",BaseParam.class,BaseParam.class),
	//登陆后修改密码
	CHANGE_PASSWD_AFTER_LOGIN("changePassWdAfterLogin",ChangePasswdAfterLoginParam.class,BaseResult.class),
	//登陆前修改密码
	CHANGE_PASSWD_BEFORE_LOGIN("changePassWdBeforeLogin",ChangePasswdBeforeLoginParam.class,BaseResult.class),
	//登陆前修改密码验证码获取
	GET_CHANGE_PASSWORD_VALID_CODE("getChangePassWordValidCode",BaseParam.class,ValidCodeResult.class),
	
	
	/*************消息发送相关部分*************/
	//发送消息
	SEND_MESSAGE("sendMessage",MessageParam.class,BaseResult.class),
	//删除消息
	DELETE_MESSAGE("deleteMessage",MessageParam.class,BaseResult.class),
	//重发消息
	RESEND_MESSAGE("reSendMessage",MessageParam.class,BaseResult.class),
	
	/*************消息获取相关部分*************/
	//获取用户发信列表
	GET_USER_SEND_MESSAGE_LIST("getUserSendMessageList",UserMessageListParam.class,MessageListResult.class),
	//获取用户收信列表
	GET_USER_RECIEVED_MESSAGE_LIST("getUserRecievedMessageList",UserMessageListParam.class,MessageListResult.class),
	//获取指定信息
	GET_MESSAGE("getMessage",MessageParam.class,MessageResult.class),
	
	/*************系统配置相关部分*************/
	//获取用户发信列表
	GET_CONFIG_LIST("getConfigList",BaseParam.class,ConfigListResult.class),
	//获取用户收信列表
	GET_CLIENTVERSION_LIST("getClientVersionList",BaseParam.class,ClientVersionListResult.class),
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
