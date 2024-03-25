package com.ganga.payloads;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDto {
	
	public int categoryId;
	
	@NotEmpty(message="The name of the category must not be empty")
	public String categoryName;
	
	@NotEmpty(message="Please do provide the description of the category")
	public String categoryDescription;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto(int categoryId,
			@NotEmpty(message = "The name of the category must not be empty") String categoryName,
			@NotEmpty(message = "Please do provide the description of the category") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto() {
		super();
	}
	
	

}
