package com.ganga.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
//import lombok.Data;

//@Data
public class JwtAuthRequest {
	
	@Email(message="Enter Valid Email Id")
	@NotEmpty(message="The Email must not be empty")
	private String username;
	@NotEmpty(message="The password must not be empty")
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtAuthRequest(
			@Email(message = "Enter Valid Email Id") @NotEmpty(message = "The Email must not be empty") String username,
			@NotEmpty(message = "The password must not be empty") String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
