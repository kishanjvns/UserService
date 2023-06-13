package com.tech.kj.dto;

public class ApiResponseDto {
	private String message;
	private String statusCode;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ApiResponseDto [message=" + message + ", statusCode=" + statusCode + ", data=" + data + "]";
	}
	
}
