package com.ganga.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductUserId {
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProductUserId(int productId, int userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public ProductUserId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
