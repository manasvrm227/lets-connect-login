//package com.lc.security;
//
//import java.util.ArrayList;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import com.lc.model.User;
//import com.lc.repository.AuthorityRepository;
//
//@Service
//public class LetsConnectLoginUserDetails implements UserDetails {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -5043708696179584071L;
//
//	@Autowired
//	AuthorityRepository authorityRepository;
//	
//	private String userName;
//	private String password;
//	private boolean enabled;
//	private List<GrantedAuthority> authorities;
//	
//	
//	public LetsConnectLoginUserDetails(User user) {
//		this.userName = user.getUserName();
//		this.password = user.getPassword();
//		this.enabled = user.isEnabled();
//		List<GrantedAuthority> temp = new ArrayList<>();
//		temp.add(new SimpleGrantedAuthority("ROLE_USER"));
//		temp.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//		this.authorities = temp;
//		System.out.println("AUTH: "+this.authorities);
//		System.out.println("username: "+ this.userName);
//		try {
//		System.out.println(authorityRepository.findByUserName(this.userName));
//		System.out.println("AUTHORITY: "+authorityRepository.findByUserName(this.userName).get().getAuthority());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
////		this.authorities = Arrays.stream(authorityRepository.findByUserName(this.userName).get().getAuthority().split(","))
////									.map(SimpleGrantedAuthority :: new).collect(Collectors.toList());
//	}
//	
//	public LetsConnectLoginUserDetails() {
//	}
//
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return this.authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return this.password;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return this.enabled;
//	}
//
//}
