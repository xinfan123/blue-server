package com.xinfan.msgbox.service.sms.impl.bean;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.xinfan.msgbox.config.SmsFileConfig;
import com.xinfan.msgbox.http.util.HttpUtils;

public class YunpianSmsBean {

	
	public static final long REGISTER_TPL_ID;
	
	public static final long CHANGE_PASSWORD_TPL_ID;
	/**
	 * 服务http地址
	 */
	private static String BASE_URI = "http://yunpian.com";
	/**
	 * 服务版本号
	 */
	private static String VERSION = "v1";
	/**
	 * 查账户信息的http地址
	 */
	private static String URI_GET_USER_INFO = BASE_URI + "/" + VERSION + "/user/get.json";
	/**
	 * 通用发送接口的http地址
	 */
	private static String URI_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/send.json";
	/**
	 * 模板发送接口的http地址
	 */
	private static String URI_TPL_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/tpl_send.json";
	
	
	private static HttpClient httpClient = new DefaultHttpClient();
	
	private static final String AIP_KEY ;
	
	static{
		REGISTER_TPL_ID = SmsFileConfig.getInstance().getLong("yunpian_sms_register_tpl_id");
		CHANGE_PASSWORD_TPL_ID = SmsFileConfig.getInstance().getLong("yunpian_sms_change_password_tpl_id");
		AIP_KEY = SmsFileConfig.getInstance().getString("yunpian_sms_apikey");
		
		 httpClient.getParams().setParameter("http.protocol.content-charset",HTTP.UTF_8);  
         httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, HTTP.UTF_8);  
         httpClient.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);  
         httpClient.getParams().setParameter(HTTP.DEFAULT_PROTOCOL_CHARSET,HTTP.UTF_8);  
	}
	
	/**
	 * 取账户信息
	 * @return json格式字符串
	 * @throws IOException 
	 */
	public static String getUserInfo(String apikey){
		try{
			Map<String,String> paramMap = new HashMap<String, String>();
			paramMap.put("apikey", apikey);
			List<NameValuePair> params = HttpUtils.toNameValues(paramMap);
			
			HttpGet httpGet = new HttpGet(URI_GET_USER_INFO);
			String str = EntityUtils.toString(new UrlEncodedFormEntity(params)); 
			httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));  
			HttpResponse httpResponse = httpClient.execute(httpGet);  
			   // 获取返回数据  
	        HttpEntity entity = httpResponse.getEntity();  
	        
			return EntityUtils.toString(entity);  
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 发短信
	 * @param apikey apikey
	 * @param text　短信内容　
	 * @param mobile　接受的手机号
	 * @return json格式字符串
	 * @throws IOException 
	 */
	public static String sendSms(String text, String mobile) throws IOException{
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("apikey", AIP_KEY);
		paramMap.put("text", text);
		paramMap.put("mobile", mobile);
		
		List<NameValuePair> params = HttpUtils.toNameValues(paramMap);
         // Post请求  
         HttpPost httppost = new HttpPost(URI_SEND_SMS);  
         //设置post编码  
          httppost.setEntity(new UrlEncodedFormEntity(params));   
         // 发送请求  
         HttpResponse httpresponse = httpClient.execute(httppost);  
         // 获取返回数据  
         HttpEntity entity = httpresponse.getEntity();  
         return EntityUtils.toString(entity);  
	}
	
	/**
	 * 通过模板发送短信
	 * @param apikey apikey
	 * @param tpl_id　模板id
	 * @param tpl_value　模板变量值　
	 * @param mobile　接受的手机号
	 * @return json格式字符串
	 * @throws IOException 
	 */
	public static String tplSendSms(long tpl_id, String tpl_value, String mobile) throws IOException{
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("apikey", AIP_KEY);
		paramMap.put("tpl_id", String.valueOf(tpl_id));
		paramMap.put("tpl_value", tpl_value);
		paramMap.put("mobile", mobile);
		
		List<NameValuePair> params = HttpUtils.toNameValues(paramMap);
		
		 // Post请求  
        HttpPost httppost = new HttpPost(URI_TPL_SEND_SMS);  
         httppost.setEntity(new UrlEncodedFormEntity(params));   
        // 发送请求  
        HttpResponse httpresponse = httpClient.execute(httppost);  
        // 获取返回数据  
        HttpEntity entity = httpresponse.getEntity();  
        return EntityUtils.toString(entity);  
	}
}
