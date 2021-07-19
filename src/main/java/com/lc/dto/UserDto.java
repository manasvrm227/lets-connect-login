package com.lc.dto;

import com.lc.model.User;

public class UserDto {

	private String userName;
	private String password;
	private boolean enabled;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public User getUser() {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEnabled(enabled);
		return user;
	}
}
