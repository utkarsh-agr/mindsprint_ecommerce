package com.ganga.services;

import java.util.List;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.WishlistDto;

public interface WishlistServices {
	
	public List<WishlistDto> getMyWishlists(int userId);
	
	public WishlistDto addAWishlist(WishlistDto wishlistDto);
	
	public ApiResponse deleteAWishlist(int wishlistId, int userId);
	
	public ApiResponse addAProductToWishList(int wishlistId,int productId);
	
	public ApiResponse removeAProductFromWishList(int wishlistId,int productId);
	

}
