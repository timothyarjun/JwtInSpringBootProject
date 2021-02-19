package com.spring.Securityjwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtpRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String otp;
	
	//private UserRegister userid;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public OtpRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		
}
