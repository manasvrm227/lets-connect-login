package com.lc.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

	@Autowired
	AuthorityRepository authorityRepository;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByUserName(username);
//		System.out.println("USER: "+user.get().getUserName());
//		user.orElseThrow(()-> new UsernameNotFoundException("Not Found :"+username));
//		return user.map(LetsConnectLoginUserDetails :: new).get();
//	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userRepo = userRepository.findByUserName(username);
		userRepo.orElseThrow(()-> new UsernameNotFoundException("Not Found :"+username));
		List<GrantedAuthority> temp = new ArrayList<>();
		temp.add(new SimpleGrantedAuthority("ROLE_USER"));
		temp.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		try {
			List<Authority> li = (List<Authority>) authorityRepository.findByUserName(username).get();
			System.out.println(li.get(0).getAuthority());
			List<GrantedAuthority> grantedAuth = new ArrayList<>();
			
			li.forEach((tempA) ->{
				grantedAuth.add(new SimpleGrantedAuthority(tempA.getAuthority()));
			});
//		System.out.println(authorityRepository.findByUserName(username).get().getAuthority());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, userRepo.get().getPassword(), true, true, true, true, grantedAuth);
		return userDetails;
	}
}