package com.lc.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lc.model.Authority;
import com.lc.model.User;
import com.lc.repository.AuthorityRepository;
import com.lc.repository.UserRepository;

@Service
public class LetsConnectLoginUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	AuthorityRepository authorityRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found :"+username));
		return user.map(LetsConnectLoginUserDetails :: new).get();
	}
}