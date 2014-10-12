package com.xinfan.msgbox.common;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * JSON 返回给调用都的结果包装对象
 * 
 * @author cyp
 *
 */
public class JSONResult extends HashMap<String,Object> {

	public JSONResult()
	{
		
	}
	
	public JSONResult(JSONObject map)
	{
		put("RETURNID", map.getIntValue("RETURNID"));
		put("RETURNDESC", map.getString("RETURNDESC"));
		put("RETURNVALUE", map.get("RETURNVALUE"));
	}
	
	public JSONResult(BaseResult result)
	{
		put("RETURNID", result.getResult());
		put("RETURNDESC", result.getMessage());
		put("RETURNVALUE", result.getValue());
	}
	
	
	public JSONResult putReturnId(int id) {
		put("RETURNID", id);
		return this;
	}
	
	public JSONResult putReturnDesc(String desc) {
		put("RETURNDESC", desc);
		return this;
	}
	
	public JSONResult putReturnValue(Object value) { 
		this.put("RETURNVALUE", value);
		return this;
	}	
	
	public JSONResult putReturn(int id,String desc,Object value){
		return putReturnId(id).putReturnDesc(desc).putReturnValue(value);
	}

	public JSONResult putReturn(int id, String desc) {
		this.put("RETURNID", id);
		this.put("RETURNDESC", desc);
		this.put("RETURNVALUE", new HashMap(0));
		return this;
	}
	
	public static JSONResult success(){
		return success("处理成功");
	}
	
	public static JSONResult success(String msg){
		JSONResult result = new JSONResult();
		result.put("RETURNID", Constants.JSON_SUCCESS);
		result.put("RETURNDESC", msg);
		result.put("RETURNVALUE", new HashMap(0));
		return result;
	}
	
	
	public static JSONResult success(String msg,Map returnValue){
		JSONResult result = new JSONResult();
		result.put("RETURNID", Constants.JSON_SUCCESS);
		result.put("RETURNDESC", msg);
		result.put("RETURNVALUE", returnValue);
		return result;
	}
	
	public static JSONResult error(){
		return error("处理失败");
	}
	
	
	public static JSONResult paramInValid(){
		return paramInValid("参数不全");
	}
	
	public static JSONResult paramInValid(String msg){
		JSONResult result = new JSONResult();
		result.put("RETURNID", -1);
		result.put("RETURNDESC", msg);
		result.put("RETURNVALUE", new HashMap(0));
		return result;
	}
	
	
	public static JSONResult error(String msg){
		JSONResult result = new JSONResult();
		result.put("RETURNID", Constants.JSON_ERROR);
		result.put("RETURNDESC", msg);
		result.put("RETURNVALUE", new HashMap(0));
		return result;
	}
	
	public String getString(String key) {
		if (key == null) {
			return "";
		}
		Object value = get(key.toUpperCase());
		if (value == null) {
			return "";
		} else {
			return String.valueOf(value);
		}
	}
	
	public int getInt(String key) {
		String value = getString(key);
		return Integer.parseInt(value);
	}
	
	public String toString() {
		return JSONUtils.toJSONString(this);
	}
	
}
