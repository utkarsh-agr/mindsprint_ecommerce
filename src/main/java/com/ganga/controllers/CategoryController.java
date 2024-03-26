package com.ganga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/{categoryId}/delete_category")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ApiResponse> RemoveCategory(@PathVariable(name = "categoryId") int categoryId){
		this.categoryServices.RemoveCategory(categoryId);
		return ResponseEntity.ok(new ApiResponse("Category deleted successfully",true));
	}
	
	@GetMapping("/{categoryId}/get_category")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "categoryId") int categoryId){
		return ResponseEntity.ok(this.categoryServices.getCategoryById(categoryId));
	}
	
	@GetMapping("/get_all_categories")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		return ResponseEntity.ok(this.categoryServices.getAllCategories());
	}
}
