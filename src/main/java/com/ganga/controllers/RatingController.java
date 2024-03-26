package com.ganga.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.RatingDto;
import com.ganga.services.RatingServices;

import jakarta.validation.Valid;

@RestController
public class RatingController {
	
	@Autowired
	RatingServices ratingServices;
	
	@PostMapping("/{productId}/set_rating")
	public ResponseEntity<RatingDto> setRating(@Valid @RequestBody RatingDto ratingDto, @PathVariable(name="productId") int productId, Principal principal){
		return ResponseEntity.ok(this.ratingServices.setRating(productId, principal, ratingDto));
	}
	
	@GetMapping("/{productId}/rating_of_user_for_product")
	public ResponseEntity<RatingDto> getRatingById(@PathVariable(name="productId") int productId, Principal principal){
		return ResponseEntity.ok(this.ratingServices.getRatingById(productId, principal));
	}
	
	@GetMapping("/ratings_of_user")
	public ResponseEntity<List<RatingDto>> getRatingOfUser(Principal principal){
		return ResponseEntity.ok(this.ratingServices.getAllRatingsOfAUser(principal));
	}
	
	@GetMapping("/{productId}/ratings_of_product")
	public ResponseEntity<List<RatingDto>> getRatingOfProduct(@PathVariable(name = "productId") int productId){
		return ResponseEntity.ok(this.ratingServices.getAllRatingsForAProduct(productId));
	}
}
