package com.firstSpringProject.Blog.payloads;

import java.io.Serializable;

public class RequestResponseDTO implements Serializable{
	
	private String message;
	private String info;
	private int reqType;
	
	
	public int getReqType() {
		return reqType;
	}

	public void setReqType(int reqType) {
		this.reqType = reqType;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
