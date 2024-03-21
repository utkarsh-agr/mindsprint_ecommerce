package com.ganga.payloads;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDto {
	
	public int categoryId;
	
	@NotEmpty(message="The name of the category must not be empty")
	public int categoryName;
	
	@NotEmpty(message="Please do provide the description of the category")
	public int categoryDescription;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(int categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(int categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto(int categoryId,
			@NotEmpty(message = "The name of the category must not be empty") int categoryName,
			@NotEmpty(message = "Please do provide the description of the category") int categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public CategoryDto() {
		super();
	}
	
	

}
