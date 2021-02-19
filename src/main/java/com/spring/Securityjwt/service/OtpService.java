package com.spring.Securityjwt.service;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.dto.MailData;
import com.spring.Securityjwt.model.UserRegister;
import com.spring.Securityjwt.repository.UserRegisterRepo;
@Service
public class OtpService {
	  	@Value("${spring.mail.username}")
	    private String fromMail;
	    private OtpGenerator otpGenerator;
	    private MailServiceImpl emailService;
	    private UserRegisterRepo userRepo;

	    /**
	     * Constructor dependency injector
	     * @param otpGenerator - otpGenerator dependency
	     * @param emailService - email service dependency
	     * @param userService - user service dependency
	     */
	    public OtpService(OtpGenerator otpGenerator, MailServiceImpl emailService,UserRegisterRepo userRepo)
	    {
	        this.otpGenerator = otpGenerator;
	        this.emailService = emailService;
	        this.userRepo = userRepo;
	    }

	    /**
	     * Method for generate OTP number
	     *
	     * @param key - provided key (username in this case)
	     * @return boolean value (true|false)
	     * @throws MessagingException 
	     */
	    public Boolean generateOtp(String key) throws MessagingException
	    {
	        // generate otp
	        Integer otpValue = otpGenerator.generateOTP(key);
	        System.out.println(otpValue);
	        if (otpValue == -1)
	        {	           
	            return  false;
	        }

	      

	        // fetch user e-mail from database
	        UserRegister userEmail = userRepo.findByPhoneOrEmail(key);
	        System.out.println(userEmail +" "+ key );
	       // List<String> recipients = new ArrayList<>();
	       // recipients.add(userEmail);

	        // generate emailDTO object
	        
	        MailData emailDTO = new MailData();
	        emailDTO.setSubject("Spring Boot OTP Password.");
	        emailDTO.setContext("OTP Password: " + otpValue);
	        emailDTO.setToAddress(userEmail.getEmail());
	        emailDTO.setFromAddress(fromMail);
	        emailDTO.setDate(new Date());

	        // send generated e-mail
	        return emailService.send(emailDTO);
	    }

	    /**
	     * Method for validating provided OTP
	     *
	     * @param key - provided key
	     * @param otpNumber - provided OTP number
	     * @return boolean value (true|false)
	     */
	    public Boolean validateOTP(String key, Integer otpNumber)
	    {
	        // get OTP from cache
	        Integer cacheOTP = otpGenerator.getOPTByKey(key);
	        if (cacheOTP.equals(otpNumber))
	        {
	            otpGenerator.clearOTPFromCache(key);
	            return true;
	        }
	        return false;
	    }
}
