package com.spring.Securityjwt.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MailData {

	private long id;
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String context;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date = new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MailData() {
		
	}	
}
