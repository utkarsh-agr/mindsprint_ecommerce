package com.ganga.services;

import java.util.List;

import com.ganga.payloads.CategoryDto;

public interface CategoryServices {
	
	public CategoryDto addCategory(CategoryDto categoryDto);
	
	public void RemoveCategory(int categoryId);
	
	public CategoryDto getCategoryById(int categoryId);
	
	public List<CategoryDto> getAllCategories();

}
