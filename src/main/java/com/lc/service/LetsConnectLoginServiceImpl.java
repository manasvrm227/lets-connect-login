package com.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.dao.LetsConnectLoginDao;
import com.lc.model.User;

@Service
public class LetsConnectLoginServiceImpl implements LetsConnectLoginService{

	@Autowired
	LetsConnectLoginDao letsConnectLoginDao;
	
	@Override
	public boolean registerUser(User user) {
		return letsConnectLoginDao.registerUser(user);
	}

}
