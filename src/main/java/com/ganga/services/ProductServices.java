package com.ganga.services;

import java.util.List;
import com.ganga.payloads.ProductDto;

public interface ProductServices {
	
	public List<ProductDto> getAllProducts();
	
	public ProductDto getProductById(int id);
	
	public void removeProductById(int id);
	
	public List<ProductDto> getByProductCategory(int categoryId);
	
	public ProductDto AddProduct(ProductDto productDto, int categoryId);
	
	public ProductDto updateQuantity(long newQuantity, int productId);
	
	public ProductDto updateProductName(String newName, int productId);
	
	public ProductDto updateAmount(double newAmount, int productId);
	
	
	

}
