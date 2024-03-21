package com.ganga.payloads;

import java.util.List;
import java.util.Set;

import com.ganga.entities.Role;

//import lombok.Data;

//@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto userDto;
	
	private Set<Role> roles;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public JwtAuthResponse(String token, UserDto userDto, Set<Role> roles) {
		super();
		this.token = token;
		this.userDto = userDto;
		this.roles=roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public JwtAuthResponse() {
		super();
	}
	
	
}
