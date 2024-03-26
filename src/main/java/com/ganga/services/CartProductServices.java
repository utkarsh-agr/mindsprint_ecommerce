package com.ganga.services;

import java.util.List;

import com.ganga.entities.CartProduct;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.CartProductDto;

public interface CartProductServices {
	
	public ApiResponse setProductToCart(CartProductDto cartProductDto,int productId, int userId);
	
	public ApiResponse deleteProductFromCart(int productId, int userId);
	
	public List<CartProductDto> getAllCartProductsForAUser(int userId);
	
	public List<CartProductDto> getAllCartProductsForAUserSelected(int userId);
	
	public ApiResponse increaseQuantityByOne(int productId, int userId);
	
	public ApiResponse decreaseQuantityByOne(int productId, int userId);
	
	public ApiResponse unselect(int productId, int userId);

}
