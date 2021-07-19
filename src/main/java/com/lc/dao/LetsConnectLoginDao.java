package com.lc.dao;

import org.springframework.stereotype.Repository;

import com.lc.model.User;

//@Repository
public interface LetsConnectLoginDao {

	public boolean registerUser(User user);
}
