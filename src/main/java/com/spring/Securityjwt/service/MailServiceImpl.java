package com.spring.Securityjwt.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.Securityjwt.dto.MailData;
@Service
public class MailServiceImpl implements MailService {
	private JavaMailSender javamailsender;
	
	 public MailServiceImpl(JavaMailSender javamailsender) {
		this.javamailsender=javamailsender;
	}
	
	@Override
	public Boolean send(MailData emailDTO)
			throws MessagingException {
		MimeMessage message= javamailsender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(message, true);
		helper.setFrom(emailDTO.getFromAddress());
		helper.setTo(emailDTO.getToAddress());
		helper.setSubject(emailDTO.getSubject());
		helper.setText(emailDTO.getContext(),true);
		helper.setSentDate(emailDTO.getDate());
		boolean isSend=false;
		try {
			javamailsender.send(message);
			isSend = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSend;
	}

}
