package com.common.security.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails{
	
	private String USER_ID;
	private String USER_PASSWORD;
	private String USER_NAME;
	private String AUTHORITY;
	private boolean ENABLED;
	
	private static Logger log = LoggerFactory.getLogger(CustomUserDetails.class);
	
	
	public String getUSER_NAME() {
		return USER_NAME;
		
	}


	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(AUTHORITY));
		log.info("*************** 로그인 계정의 권한 ***************"+auth);
		return auth;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return USER_PASSWORD;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return USER_ID;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ENABLED;
	}


	@Override
	public String toString() {
		return "CustomUserDetails [USER_ID=" + USER_ID + ", USER_PASSWORD=" + USER_PASSWORD + ", USER_NAME=" + USER_NAME
				+ ", AUTHORITY=" + AUTHORITY + ", ENABLED=" + ENABLED + "]";
	}
	
		

	
	
	
}
