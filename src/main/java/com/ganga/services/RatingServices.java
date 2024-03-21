package com.ganga.services;

import com.ganga.payloads.RatingDto;

public interface RatingServices {
	
	public RatingDto getRatingById(int productId, int userId);
	
	public RatingDto setRating(int productId, int userId, RatingDto ratingDto);

}
