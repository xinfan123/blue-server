package com.xinfan.msgbox.http.service.vo.param;


/**
 * 注册参数vo
 * @author Administrator
 *
 */
public class RegisterParam extends BaseParam{
	private String validCode;
	private String mobile;
	private String passwd;
	
	private String regGpsy;

    private String regGpsx;

    private String regEarea;

	
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRegGpsy() {
		return regGpsy;
	}
	public void setRegGpsy(String regGpsy) {
		this.regGpsy = regGpsy;
	}
	public String getRegGpsx() {
		return regGpsx;
	}
	public void setRegGpsx(String regGpsx) {
		this.regGpsx = regGpsx;
	}
	public String getRegEarea() {
		return regEarea;
	}
	public void setRegEarea(String regEarea) {
		this.regEarea = regEarea;
	}
	
	
}
