package com.ganga.payloads;


//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import java.util.HashSet;
//import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@NoArgsConstructor
//@Getter
//@Setter
@JsonIgnoreProperties(value="userPassword", allowSetters = true)
public class UserDto {
	
	public int userId;
	
	@NotEmpty(message="The name of the user must not be empty")
	@Size(min=4,message="The name of user must be of more than 4 characters")
	public String userFullName;
	
	@NotEmpty(message="The email must not be empty")
	@Email(message="Enter valid email")
	public String userEmail;
	
	@NotEmpty(message="The password must not be empty")
	@Size(min=5, message="The password of user must be of more than 5 characters")
	private String userPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public UserDto(int userId,
			@NotEmpty(message = "The name of the user must not be empty") @Size(min = 4, message = "The name of user must be of more than 4 characters") String userFullName,
			@NotEmpty(message = "The email must not be empty") @Email(message = "Enter valid email") String userEmail,
			@NotEmpty(message = "The password must not be empty") @Size(min = 5, message = "The password of user must be of more than 5 characters") String userPassword
			) {
		super();
		this.userId = userId;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public UserDto() {
		super();
	}
	
	
	
	//private Set<CommentDto> comments=new HashSet<>();

}
