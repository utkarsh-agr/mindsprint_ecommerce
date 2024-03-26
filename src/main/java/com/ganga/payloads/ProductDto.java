package com.ganga.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDto {
	
	
	public int productId;
	
	@NotEmpty(message = "The name of the product must not be Empty")
	@Size(min = 3, message = "The name of the product must be more than 3 characters")
	public String productName;
	
	@NotEmpty(message="Please enter the price of the product")
	public double productPrice;
	
	public String productDescription;
	
	@NotEmpty(message="Please enter the quantity of products you have in the stock")
	public long productQuantity;
	
	public double productRating;
	
	public String productImageUrl;
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}
	
	

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	
	public ProductDto(int productId,
			@NotEmpty(message = "The name of the product must not be Empty") @Size(min = 3, message = "The name of the product must be more than 3 characters") String productName,
			@NotEmpty(message = "Please enter the price of the product") double productPrice, String productDescription,
			@NotEmpty(message = "Please enter the quantity of products you have in the stock") long productQuantity,
			double productRating, String productImageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productRating = productRating;
		this.productImageUrl = productImageUrl;
	}
	

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
