package com.ganga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.CategoryDto;
import com.ganga.services.CategoryServices;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryServices categoryServices; 
	
	@PostMapping("/add_category")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ApiResponse> addCategory(@RequestBody CategoryDto categoryDto){
		this.categoryServices.addCategory(categoryDto);
		return ResponseEntity.ok(new ApiResponse("Category added successfully",true));
	}

}
