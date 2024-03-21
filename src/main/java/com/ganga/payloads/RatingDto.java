package com.ganga.payloads;

import jakarta.validation.constraints.NotEmpty;

public class RatingDto {
	
	@NotEmpty(message="Please rate the product before giving review")
	public double ratedValue;
	
	public String rateReview;

	public double getRatedValue() {
		return ratedValue;
	}

	public void setRatedValue(double ratedValue) {
		this.ratedValue = ratedValue;
	}

	public String getRateReview() {
		return rateReview;
	}

	public void setRateReview(String rateReview) {
		this.rateReview = rateReview;
	}

	public RatingDto(@NotEmpty(message = "Please rate the product before giving review") double ratedValue,
			String rateReview) {
		super();
		this.ratedValue = ratedValue;
		this.rateReview = rateReview;
	}

	public RatingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
