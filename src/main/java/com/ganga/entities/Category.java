package com.ganga.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category_details")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name="category_name", nullable=false, length=1000)
	private String categoryName;
	
	@Column(name="category_description", length = 10000)
	private String CategoryDescription;
	
	@OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
	private List<Products> categoryProducts=new ArrayList<>();

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
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public List<Products> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(List<Products> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, String categoryDescription, List<Products> categoryProducts) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		CategoryDescription = categoryDescription;
		this.categoryProducts = categoryProducts;
	}
	
	

}
