package com.spring.Securityjwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Securityjwt.common.APIResponse;
import com.spring.Securityjwt.dto.AuthenticationResponseVM;
import com.spring.Securityjwt.model.AuthenticationRequest;
import com.spring.Securityjwt.model.UserRegister;
import com.spring.Securityjwt.service.MyUserDetailsService;
import com.spring.Securityjwt.service.UserRegisterService;
import com.spring.Securityjwt.util.JwtUtil;

@RestController
public class HelloController {
	private final Integer status_Ok = 200;
	private final String errordata = "User not available";
	private AuthenticationManager authenticationManager;		
	private MyUserDetailsService userdetailsservice;		
	private JwtUtil jwtTokenUtil;
	private UserRegisterService userRegisterService;	
	
	
	@Autowired	
	public HelloController(AuthenticationManager authenticationManager, MyUserDetailsService userdetailsservice,
			JwtUtil jwtTokenUtil, UserRegisterService userRegisterService) {
		super();
		this.authenticationManager = authenticationManager;
		this.userdetailsservice = userdetailsservice;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userRegisterService = userRegisterService;		
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Arjun";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<APIResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		
		final UserDetails userDetails = userdetailsservice.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		//return ResponseEntity.ok(new AuthenticationResponseVM(jwt));
		APIResponse ap = new APIResponse();
		ap.setData(new AuthenticationResponseVM(jwt));
		ap.setStatus(status_Ok);
		return ResponseEntity.ok().body(ap);
	}
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse> register(@Valid @RequestBody UserRegister register) {
		APIResponse ap = new APIResponse();
		ap.setData(userRegisterService.register(register));
		ap.setStatus(status_Ok);
		return ResponseEntity.ok().body(ap);
		}
	
	@PutMapping("/update/{id}")
	public  ResponseEntity<APIResponse> updateRegister(@PathVariable long id, @Valid @RequestBody UserRegister register) {
		UserRegister user = userRegisterService.findOne(id);
		APIResponse ap = new APIResponse();
		if(user != null) {
			UserRegister u = new UserRegister();
			u.setId(user.getId());
			u.setFname(register.getFname());
			u.setLname(register.getLname());
			u.setPassword(register.getPassword());
			u.setPhone(register.getPhone());
			u.setEmail(register.getEmail());			
			ap.setData(userRegisterService.register(u));
			ap.setStatus(status_Ok);
			return ResponseEntity.ok().body(ap);
		}
		else {
			ap.setError(errordata);
			ap.setStatus(400);
			return ResponseEntity.ok().body(ap);
		}
				
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<APIResponse> getOne(@PathVariable long id) {
		APIResponse ap = new APIResponse();
		ap.setData(userRegisterService.findOne(id));
		ap.setStatus(status_Ok);
		return ResponseEntity.ok().body(ap);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<APIResponse> getAll() {
		APIResponse ap = new APIResponse();
		ap.setData(userRegisterService.findAll());
		ap.setStatus(status_Ok);
		 return ResponseEntity.ok().body(ap);
	}
		
}
