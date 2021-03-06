package com.spring.Securityjwt.common;

public class APIResponse {
	private Integer status;
	private Object data;
	private Object error;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	
	public APIResponse() {
			}
	
	public APIResponse(Integer status, Object data, Object error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
	}
	
	
}
