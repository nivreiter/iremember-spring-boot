package com.iremember.prayer.api.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iremember.prayer.actions.PrayerActions;
import com.iremember.prayer.api.ApiRequestHandler;
import com.iremember.prayer.api.RestResponse;

@RestController
@RequestMapping(value=Endpoints.EXTERMAL_SERVERICES)
public class ExternalRestApi {
	
	@Autowired
	private PrayerActions prayerAction;
	
	@RequestMapping(value = "get-prayer", method = RequestMethod.GET)
	public RestResponse getPrayer(@RequestParam(value="firstName", required=true) String firstName) {
		return ApiRequestHandler.handleApiRequest(() -> {
			return prayerAction.getPrayer(firstName);
		});	
	}

}
