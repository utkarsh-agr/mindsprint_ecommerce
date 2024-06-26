package com.ganga.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.entities.User;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.UserDto;
import com.ganga.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apis/users")
public class UserController {
	
	@Autowired
	UserServices userServices;
	
	@GetMapping("/makeadmin/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<UserDto> giveAdminPrivilage(@PathVariable("userId") int userId){
		return ResponseEntity.ok(this.userServices.giveAdminPrivilage(userId));
	}
	
	@GetMapping("/makeadminonly/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<UserDto> giveAdminPrivilageOnly(@PathVariable("userId") int userId){
		return ResponseEntity.ok(this.userServices.giveAdminPrivilageOnly(userId));
	}
	
	@GetMapping("/")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<UserDto> allUsersList = this.userServices.getAllUsers();
		
		if(allUsersList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(allUsersList));
	}
	
	@GetMapping("/{userId}")
	
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") int userId){
		
		return ResponseEntity.ok(this.userServices.getUserById(userId));
		
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") int userId ){
		
			this.userServices.updateUser(userDto, userId);
		
		
			return new ResponseEntity<>(new ApiResponse("User updated successfully", true),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable int userId){
		
			this.userServices.deleteUserById(userId);
		
		
		return new ResponseEntity<>(new ApiResponse("User deleted successfully", true),HttpStatus.ACCEPTED);
	}

}
