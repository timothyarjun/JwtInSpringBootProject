package com.spring.Securityjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.model.UserRegister;
import com.spring.Securityjwt.repository.UserRegisterRepo;

@Service
public class UserRegisterService {
	private UserRegisterRepo userRegisterRepo;
	
	@Autowired
	public UserRegisterService(UserRegisterRepo userRegisterRepo) {
		super();
		this.userRegisterRepo = userRegisterRepo;
	}
	
	public UserRegister register(UserRegister register) {
		return userRegisterRepo.save(register);
	}

	public UserRegister findOne(long id) {
		return userRegisterRepo.getOne(id);
	}

	public List<UserRegister> findAll() {
		return userRegisterRepo.findAll();
	}
	
	
}
