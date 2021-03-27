package com.iremember.prayer.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class RestResponse implements Serializable{
	
	private static final long serialVersionUID = -5564295171137636831L;
	
	private boolean isSuccess;
	private String errorDescription;
	private Object payload;
		
	public RestResponse() {
		super();
	}
	
	public RestResponse(boolean isSuccess, String errorDescription, Object payload) {
		super();
		this.isSuccess = isSuccess;
		this.errorDescription = errorDescription;
		this.payload = payload;
	}
	
}
