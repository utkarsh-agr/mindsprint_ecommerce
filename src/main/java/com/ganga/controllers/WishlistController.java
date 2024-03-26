package com.ganga.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.RatingDto;
import com.ganga.payloads.WishlistDto;
import com.ganga.services.WishlistServices;

import jakarta.validation.Valid;

@RestController
public class WishlistController {
	
	@Autowired
	WishlistServices wishlistServices;
	
	@PostMapping("/add_wishlist")
	public ResponseEntity<WishlistDto> addAWishlist(@Valid @RequestBody WishlistDto wishlistDto, Principal principal){
		return ResponseEntity.ok(this.wishlistServices.addAWishlist(wishlistDto, principal));
	}
	
	@GetMapping("/get_my_wishlists")
	public ResponseEntity<List<WishlistDto>> getMyWishlists(Principal principal){
		return ResponseEntity.ok(this.wishlistServices.getMyWishlists(principal));
	}
	
	@GetMapping("/{productId}/product_to_wishlist/{wishlistId}")
	public ResponseEntity<ApiResponse> addAProductToWishlist(@PathVariable(name = "wishlistId") int wishlistId, @PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.wishlistServices.addAProductToWishList(wishlistId, productId));
	}
	
	@DeleteMapping("/{productId}/remove_product_from_wishlist/{wishlistId}")
	public ResponseEntity<ApiResponse> removeAProductFromWishlist(@PathVariable(name = "wishlistId") int wishlistId, @PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.wishlistServices.removeAProductFromWishList(wishlistId, productId));
	}
	
	@DeleteMapping("/{wishlistId}/remove_wishlist")
	public ResponseEntity<ApiResponse> deleteAWishlist(@PathVariable(name = "wishlistId") int wishlistId, Principal principal){
		return ResponseEntity.ok(this.wishlistServices.deleteAWishlist(wishlistId, principal));
	}
	
	
}
