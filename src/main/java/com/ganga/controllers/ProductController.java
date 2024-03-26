package com.ganga.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.ProductDto;
import com.ganga.services.ProductServices;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@PostMapping("/{categoryId}/add_product")
	public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDto productDto,@PathVariable(name = "categoryId") int categoryId){
		this.productServices.AddProduct(productDto, categoryId);
		return ResponseEntity.ok(new ApiResponse("Product added successfully",true));
	}
	
	@GetMapping("/get_all_products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> list=this.productServices.getAllProducts();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/{productId}/get_product")
	public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.productServices.getProductById(productId));
	}
	
	@GetMapping("/{categoryId}/get_products_category")
	public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable(name = "categoryId") int categoryId){
		return ResponseEntity.ok(this.productServices.getByProductCategory(categoryId));
	}
	
	
	@DeleteMapping("/{productId}/delete_product")
	public ResponseEntity<ApiResponse> removeAProduct(@PathVariable(name = "productId") int productId){
		this.productServices.removeProductById(productId);
		return ResponseEntity.ok(new ApiResponse("Product Deleted Successfully",true));
	}
	
	@PutMapping("/{productId}/update_quantity/{newQuantity}")
	public ResponseEntity<ProductDto> updateQuantity(@PathVariable(name = "newQuantity") long newQuantity, @PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.productServices.updateQuantity(newQuantity, productId));
	}
	
	@PutMapping("/{productId}/update_name/{newName}")
	public ResponseEntity<ProductDto> updateProductName(@PathVariable(name = "newName") String newName, @PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.productServices.updateProductName(newName, productId));
	}
	
	@PutMapping("/{productId}/update_amount")
	public ResponseEntity<ProductDto> updateProductAmount(@RequestBody ProductDto productDto, @PathVariable(name = "productId") int productId){
		double newAmount=productDto.getProductPrice();
		return ResponseEntity.ok(this.productServices.updateAmount(newAmount, productId));
	}
	

}
