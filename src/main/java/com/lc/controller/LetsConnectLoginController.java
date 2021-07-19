package com.lc.controller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.dto.UserDto;
import com.lc.model.User;
import com.lc.service.LetsConnectLoginService;
import com.lc.util.LetsConnectLoginCache;

@RestController
public class LetsConnectLoginController {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	LetsConnectLoginService letsConnectLoginService;

	@GetMapping("/")
	public String home() {
		return "LetsConnect Login";
	}
	
	@GetMapping("/user")
	public String homeUser() {
		return "LetsConnect User Login";
	}
	
//	@PostMapping("/register")
//	public Map<String, String> registerUser(@RequestBody UserDto userDto) throws Exception {
//		System.out.println("Body: "+ userDto.getUserName());
//		User user = modelMapper.map(userDto, User.class);
//		System.out.println("USER "+user.getUserName());
//		boolean isAdded = letsConnectLoginService.registerUser(user);
//		if(!isAdded)
//			throw new Exception("User not added");
//		return LetsConnectLoginCache.successResponse;
//	}
	
	@PostMapping("/register")
	public Map<String, String> registerUser(@RequestBody Map<String, Object> userMap) throws Exception {
		User user = new User();
		user.setUserName((String) userMap.get("username"));
		user.setPassword(new BCryptPasswordEncoder().encode((String) userMap.get("password")));
		user.setEnabled((boolean) userMap.get("enabled"));
		System.out.println("Body: "+ user.getUserName());
		boolean isAdded = letsConnectLoginService.registerUser(user);
		if(!isAdded)
			throw new Exception("User not added");
		return LetsConnectLoginCache.successResponse;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleException(Exception ex){
		System.out.println("error");
		ex.printStackTrace();
		
		Map<String, String> exMap = new HashMap<>();
		exMap.put("error", "error");
		return exMap;
		
	}
	
	
}
