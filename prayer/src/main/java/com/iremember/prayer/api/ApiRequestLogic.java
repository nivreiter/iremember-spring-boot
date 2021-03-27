package com.iremember.prayer.api;

@FunctionalInterface
public interface ApiRequestLogic {

	public Object perform() throws Exception;
	
}
