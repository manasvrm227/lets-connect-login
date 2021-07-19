package com.lc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lc.model.User;
import com.lc.repository.UserRepository;

@Repository
public class LetsConnectDaoImpl implements LetsConnectLoginDao{

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {
		User savedUser = userRepository.save(user);
		if(savedUser == null)
			return false;
		return true;
	}

}
