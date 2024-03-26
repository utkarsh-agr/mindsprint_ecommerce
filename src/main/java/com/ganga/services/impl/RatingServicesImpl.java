package com.ganga.services.impl;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.Products;
import com.ganga.entities.Rating;
import com.ganga.entities.User;
import com.ganga.entities.Ids.ProductUserId;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.RatingDto;
import com.ganga.repositories.ProductRepository;
import com.ganga.repositories.RatingRepository;
import com.ganga.repositories.UserRepository;
import com.ganga.services.RatingServices;

//This is a service that is related to the rating entity, like adding and getting a rating
@Service
public class RatingServicesImpl implements RatingServices {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	// This function will return the rating given by a user for some product
	@Override
	public RatingDto getRatingById(int productId, Principal principal) {
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		Rating rating=this.ratingRepository.findById(new ProductUserId(productId,userId)).orElseThrow(()->new ResourceNotFoundException("Rating", "IDs", 0));
		return this.ratingToDto(rating);
	}
	// This function will set the rating given by a user for some product
	@Override
	public RatingDto setRating(int productId, Principal principal, RatingDto ratingDto) {
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		Rating rating=this.dtoToRating(ratingDto);
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		Products product=this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "Id", productId));
		rating.setRatedProduct(product);
		rating.setRatedByUser(user);
		this.ratingRepository.save(rating);
		return this.ratingToDto(rating);
	}
	
	@Override
	public List<RatingDto> getAllRatingsForAProduct(int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "Id", productId));
		List<Rating> ratingList=this.ratingRepository.findByRatedProduct(product).get();
		return ratingList.stream().map(e->this.ratingToDto(e)).collect(Collectors.toList());
	}
	@Override
	public List<RatingDto> getAllRatingsOfAUser(Principal principal) {
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		List<Rating> ratingList=this.ratingRepository.findByRatedByUser(user).get();
		return ratingList.stream().map(e->this.ratingToDto(e)).collect(Collectors.toList());
	}
	
	//This function uses model mapper to map and transfer data from Rating class to RatingDto 
	public RatingDto ratingToDto(Rating rating) {
		return this.modelMapper.map(rating, RatingDto.class);
	}
	
	//This function uses model mapper to map and transfer data from RatingDto to Rating class 
	
	public Rating dtoToRating(RatingDto ratingDto) {
		return this.modelMapper.map(ratingDto, Rating.class);
	}
	
	
	

}
