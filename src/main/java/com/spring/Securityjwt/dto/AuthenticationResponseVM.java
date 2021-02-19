package com.spring.Securityjwt.dto;

public class AuthenticationResponseVM {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticationResponseVM(String jwt) {
		this.jwt = jwt;
	}
	
}
