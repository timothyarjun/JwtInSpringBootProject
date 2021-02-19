package com.spring.Securityjwt.service;

import javax.mail.MessagingException;

import com.spring.Securityjwt.dto.MailData;

public interface MailService {

	public Boolean send(MailData emailDTO) throws MessagingException;
}
