package com.spring.Securityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.Securityjwt.model.UserRegister;

public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {

	//UserRegister findByPhone(String username);
	
	@Query("select u from UserRegister u where u.phone = :name OR u.email = :name")
	UserRegister findByPhoneOrEmail(@Param("name") String username);

	

}
