package com.lc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lc.model.Authority;
import com.lc.model.User;
import com.lc.repository.AuthorityRepository;
import com.lc.repository.UserRepository;
import com.lc.util.LetsConnectLoginCache;

@Repository
public class LetsConnectDaoImpl implements LetsConnectLoginDao{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public boolean registerUser(User user) {
		User savedUser = userRepository.save(user);
		if(savedUser == null)
			return false;
		Authority authority = new Authority();
		authority.setUserName(user.getUserName());
		authority.setAuthority(LetsConnectLoginCache.ROLE_USER);
		Authority s = authorityRepository.save(authority);
		return true;
	}

}
