package com.iremember.prayer.api;

public class RestResponseFactory {

	public static RestResponse getSuccessResponse() {
		return getSuccessResponse(null);
	}
	
	public static RestResponse getSuccessResponse(Object payload) {
		RestResponse res = new RestResponse();		
		res.setSuccess(true);
		res.setPayload(payload);		
		return res;
	}
	
	public static RestResponse getFailResponse(String msg) {
		RestResponse res = new RestResponse();		
		res.setSuccess(false);
		res.setErrorDescription(msg);		
		return res;
	}
	
	public static RestResponse getFailResponse(Exception e) {
		RestResponse res = new RestResponse();		
		res.setSuccess(false);
		res.setErrorDescription( e.getMessage() );		
		return res;
	}
	
}
