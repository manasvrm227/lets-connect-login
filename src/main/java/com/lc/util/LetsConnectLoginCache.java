package com.lc.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface LetsConnectLoginCache {

	String ROLE_USER = "ROLE_USER";
	String ROLE_ADMIN = "ROLE_ADMIN";
	
	String KEY_SUCCESS = "success";
	String KEY_FAILURE = "failure";
	
	Map<String, String> successResponse = Stream.of(
			  new AbstractMap.SimpleEntry<>(KEY_SUCCESS, "success")//, 
//			  new AbstractMap.SimpleEntry<>("mobile", "2"))
			  )
			  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	
}
