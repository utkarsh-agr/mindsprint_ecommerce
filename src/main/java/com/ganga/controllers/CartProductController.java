package com.ganga.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.CartProductDto;
import com.ganga.repositories.UserRepository;
import com.ganga.services.CartProductServices;

@RestController
public class CartProductController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartProductServices cartProductServices;
	
	@PostMapping("/{productId}/add_to_cart")
	public ApiResponse addProduct(@RequestBody CartProductDto cartProductDto,@PathVariable(name="productId") int productId, Principal principal){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		this.cartProductServices.setProductToCart(cartProductDto, productId, userId);
		
		return new ApiResponse("Product added successfully", true);
	}
	@GetMapping("/get_cart_product")
	public ResponseEntity<List<CartProductDto>> getAllProductsForUser(Principal principal){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		return ResponseEntity.ok(this.cartProductServices.getAllCartProductsForAUser(userId));
	}
	
	@GetMapping("/get_cart_product_selected")
	public ResponseEntity<List<CartProductDto>> getAllProductsForUserSelected(Principal principal){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		return ResponseEntity.ok(this.cartProductServices.getAllCartProductsForAUserSelected(userId));
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<ApiResponse> deleteProductFromCart(Principal principal, @PathVariable(name = "productId") int productId){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		return ResponseEntity.ok(this.cartProductServices.deleteProductFromCart(productId, userId));
	}
	
	@PutMapping("/{productId}/increase_quantity")
	public ResponseEntity<ApiResponse> increaseQuantityByOne(Principal principal, @PathVariable(name = "productId") int productId){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		return ResponseEntity.ok(this.cartProductServices.increaseQuantityByOne(productId, userId));
	}
	
	@DeleteMapping("/{productId}/decrease_quantity")
	public ResponseEntity<ApiResponse> decreaseQuantityByOne(Principal principal, @PathVariable(name = "productId") int productId){
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		return ResponseEntity.ok(this.cartProductServices.decreaseQuantityByOne(productId, userId));
	}
	

}
