package com.ganga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ganga.entities.User;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUserEmail(userEmail).orElseThrow(()->new ResourceNotFoundException("User", "Email"+userEmail, 0));
		
		return user;
	}

}
