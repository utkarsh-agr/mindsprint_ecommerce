package com.ganga.entities;

import com.ganga.entities.Ids.ProductUserId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	
	@EmbeddedId
	private ProductUserId productUserId;

	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName = "productId", insertable = false, updatable = false)
	private Products ratedProduct;
	

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId", insertable = false, updatable = false)
	private User ratedByUser;
	
	@Column(name="rated_value")
	private double ratedValue;
	
	@Column(name="rate_review")
	private String rateReview;
	

	public Products getRatedProduct() {
		return ratedProduct;
	}

	public void setRatedProduct(Products ratedProduct) {
		this.ratedProduct = ratedProduct;
	}

	public User getRatedByUser() {
		return ratedByUser;
	}

	public void setRatedByUser(User ratedByUser) {
		this.ratedByUser = ratedByUser;
	}

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
	
	

	public ProductUserId getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(ProductUserId productUserId) {
		this.productUserId = productUserId;
	}

	public Rating(Products ratedProduct, User ratedByUser, double ratedValue, String rateReview) {
		super();
		this.ratedProduct = ratedProduct;
		this.ratedByUser = ratedByUser;
		this.ratedValue = ratedValue;
		this.rateReview = rateReview;
	}

	public Rating() {
		super();
	}
	
	
	

}
