package com.iremember.prayer.api;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiRequestHandler {

	public static RestResponse handleApiRequest(ApiRequestLogic businessesLogic) {
		try {
			Object resultObject = businessesLogic.perform();
			return RestResponseFactory.getSuccessResponse(resultObject);
		}catch(Exception e){
			log.error("Error handling api request", e);
			return RestResponseFactory.getFailResponse(e);
		}
	}
	
}
