package com.ganga.services;

import java.security.Principal;
import java.util.List;

import com.ganga.payloads.RatingDto;

public interface RatingServices {
	
	public RatingDto getRatingById(int productId, Principal principal);
	
	public RatingDto setRating(int productId, Principal principal, RatingDto ratingDto);
	
	public List<RatingDto> getAllRatingsForAProduct(int productId);
	
	public List<RatingDto> getAllRatingsOfAUser(Principal principal);

}
