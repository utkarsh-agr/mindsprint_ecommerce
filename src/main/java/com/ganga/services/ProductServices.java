package com.ganga.services;

import java.util.List;
import com.ganga.payloads.ProductDto;

public interface ProductServices {
	
	public List<ProductDto> getAllProducts();
	
	public ProductDto getProductById(int id);
	
	public void removeProductById(int id);
	
	public ProductDto AddProduct(ProductDto productDto, int categoryId);
	
	public ProductDto updateQuantity(int newQuantity, int productId);
	
	public ProductDto updateProductName(String newName, int productId);
	
	public ProductDto updateAmount(double newAmount, int productId);
	
	
	

}
