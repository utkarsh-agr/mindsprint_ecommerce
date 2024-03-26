package com.ganga.services;

import java.security.Principal;
import java.util.List;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.WishlistDto;

public interface WishlistServices {
	
	public List<WishlistDto> getMyWishlists(Principal principal);
	
	public WishlistDto addAWishlist(WishlistDto wishlistDto, Principal principal);
	
	public ApiResponse deleteAWishlist(int wishlistId,Principal principal);
	
	public ApiResponse addAProductToWishList(int wishlistId,int productId);
	
	public ApiResponse removeAProductFromWishList(int wishlistId,int productId);
	

}
