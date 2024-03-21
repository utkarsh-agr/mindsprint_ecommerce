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
	

}
