package com.spring.Securityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Securityjwt.model.OtpRegister;
@Repository
public interface OtpRepository extends JpaRepository<OtpRegister, Long> {

}
