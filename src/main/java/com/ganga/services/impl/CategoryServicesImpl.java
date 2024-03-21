package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.Category;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.CategoryDto;
import com.ganga.repositories.CategoryRepository;
import com.ganga.services.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category=this.DtoToCategory(categoryDto);
		this.categoryRepository.save(category);
		return this.categoryToDto(category);
	}

	@Override
	public void RemoveCategory(int categoryId) {
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		this.categoryRepository.delete(category);
	}

	@Override
	public CategoryDto getCategoryById(int categoryId) {
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories=this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos=categories.stream().map(e->this.categoryToDto(e)).collect(Collectors.toList());
		return categoryDtos;
	}
	
	public CategoryDto categoryToDto(Category category) {
		return this.modelMapper.map(category, CategoryDto.class);
	}
	
	public Category DtoToCategory(CategoryDto categoryDto) {
		return this.modelMapper.map(categoryDto, Category.class);
	}

}
