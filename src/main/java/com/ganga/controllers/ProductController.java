package com.ganga.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.AddressDto;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.ProductDto;
import com.ganga.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	ProductServices productServices;
	
	@PostMapping("/{categoryId}/add_product")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto,@PathVariable(name = "categoryId") int categoryId){
		this.productServices.AddProduct(productDto, categoryId);
		return ResponseEntity.ok(new ApiResponse("Product added successfully",true));
	}
	
	

}
