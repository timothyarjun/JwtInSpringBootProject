package com.spring.Securityjwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.model.UserRegister;
import com.spring.Securityjwt.repository.UserRegisterRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	private UserRegisterRepo userRepo;
	
	@Autowired
	public MyUserDetailsService(UserRegisterRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserRegister user = userRepo.findByPhoneOrEmail(username);
		return new User(username,user.getPassword(), new ArrayList<>());
	}

}
