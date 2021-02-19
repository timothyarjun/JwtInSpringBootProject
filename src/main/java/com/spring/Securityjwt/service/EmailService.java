package com.spring.Securityjwt.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.dto.EmailDTO;


@Service
public class EmailService {
	
	   @Autowired
	    private JavaMailSender emailSender;

	    /**
	     * Method for sending simple e-mail message.
	     * @param emailDTO - data to be send.
	     */
	    public Boolean sendSimpleMessage(EmailDTO emailDTO)
	    {
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setTo(emailDTO.getRecipients().stream().collect(Collectors.joining(",")));
	        mailMessage.setSubject(emailDTO.getSubject());
	        mailMessage.setText(emailDTO.getBody());

	        Boolean isSent = false;
	        try
	        {
	            emailSender.send(mailMessage);
	            isSent = true;
	        }
	        catch (Exception e) {
	           System.out.println(e);
	        }
	        return isSent;
	    }
}
