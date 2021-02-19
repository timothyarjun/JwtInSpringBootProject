package com.spring.Securityjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.model.UserRegister;
import com.spring.Securityjwt.repository.UserRegisterRepo;
@Service
public class UserService {

//	 @Autowired
//	    private UserRegisterRepo userRepository;
//
//	    /**
//	     * Method for getting all users
//	     *
//	     * @return List of user objects.
//	     */
//	    public List<UserRegister> findAllUsers() {
//	        return this.userRepository.findAll();
//	    }
//
//	    /**
//	     * Method for getting e-mail by username (key)
//	     *
//	     * @param username - provided username
//	     * @return e-mail
//	     */
//	    public String findEmailByUsername(String username)
//	    {
//	       UserRegister user = userRepository.findByPhoneOrEmail(username);
//	        if (user.isPresent()) {
//	            return user.getEmail();
//	        }
//	        return null;
//	    }
		
}
