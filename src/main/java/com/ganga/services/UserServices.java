package com.ganga.services;

import java.util.List;

import com.ganga.entities.User;
import com.ganga.payloads.UserDto;

public interface UserServices {
	
	UserDto registerUser(UserDto userdto);
	void deleteUserById(Integer userId);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	UserDto giveAdminPrivilage(int userId);
	UserDto giveAdminPrivilageOnly(int userId);

}
