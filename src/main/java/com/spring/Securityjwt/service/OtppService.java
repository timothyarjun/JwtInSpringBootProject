package com.spring.Securityjwt.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.model.OtpRegister;
import com.spring.Securityjwt.repository.OtpRepository;
@Service
public class OtppService {	
	@Autowired
	private OtpRepository otprepo;
	
	public char[] genOtp() {		
		String numbers = "0123456789";
		int otpLength = 6;
		char[] value = new char[otpLength];
		SecureRandom random = new SecureRandom();
		
		for(int i=0; i<otpLength; i++ ) {
			value[i]= numbers.charAt(random.nextInt(numbers.length()));
		}	
		return value;
	}

	
	public String generateOtp() {
		OtpRegister otp1= new OtpRegister();
		otp1.setId(otp1.getId());
		otp1.setOtp(genOtp().toString());
		
		OtpRegister otp2= otprepo.save(otp1);
		 return otp2.getOtp();
	}
	
}
