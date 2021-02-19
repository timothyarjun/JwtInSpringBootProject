package com.spring.Securityjwt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Securityjwt.service.OtpService;

@RestController
@RequestMapping("/api")
public class OTPResourceController {
	
	 private OtpService otpService;

	    /**
	     * Constructor dependency injector.
	     * @param otpService - otp service
	     */
	 @Autowired
	    public OTPResourceController(OtpService otpService) {
	        this.otpService = otpService;
	    }

	    @PostMapping(value = "generate", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> generateOTP() throws MessagingException
	    {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = authentication.getName();

	        Map<String, String> response = new HashMap<>(2);

	        // check authentication
	        if (username == null) {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }

	        // generate OTP.
	        Boolean isGenerated = otpService.generateOtp(username);
	        if (!isGenerated)
	        {
	            response.put("status", "error");
	            response.put("message", "OTP can not be generated.");

	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	        }

	        // success message
	        response.put("status", "success");
	        response.put("message", "OTP successfully generated. Please check your e-mail!");

	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @PostMapping(value = "validate", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> validateOTP(@RequestBody Map<String, Object> otp)
	    {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String username = authentication.getName();

	        Map<String, String> response = new HashMap<>(2);

	        // check authentication
	        if (username == null) {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }

	        // validate provided OTP.
	        Boolean isValid = otpService.validateOTP(username, (Integer) otp.get("otp"));
	        if (!isValid)
	        {
	            response.put("status", "error");
	            response.put("message", "OTP is not valid!");

	            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	        }

	        // success message
	        response.put("status", "success");
	        response.put("message", "Entered OTP is valid!");

	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

}
