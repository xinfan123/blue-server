package com.xinfan.msgbox.common;

public class BaseResult<T> {

	private int result;

	private String message;

	private T value;

	public BaseResult() {

	}

	public BaseResult(int result, String message, T value) {
		super();
		this.result = result;
		this.message = message;
		this.value = value;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BaseResult putResult(int result) {
		this.setResult(result);
		return this;
	}

	public BaseResult putMessage(String message) {
		this.setMessage(message);
		return this;
	}

	public BaseResult putValue(T value) {
		this.setValue(value);
		return this;
	}


}
