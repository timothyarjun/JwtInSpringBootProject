package com.spring.Securityjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User_tbl")
public class UserRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	@Column(name = "first_name")
	private String fname;
	
	@Column(name = "last_name")
	private String lname;
	
	@NotNull
	@NotBlank(message="Please enter your password")
	@Min(value = 5)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@NotBlank(message="Please enter your phone number")
	@Column(name = "phone")
	private String phone;
	
	@NotBlank(message="Please enter your email id")
	@Column(name = "email")
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRegister(long id, String fname, String lname, String password, String phone, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public UserRegister() {
		
	}
	@Override
	public String toString() {
		return "UserRegister [id=" + id + ", fname=" + fname + ", lname=" + lname + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}	

}
