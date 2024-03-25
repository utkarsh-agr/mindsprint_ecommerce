package com.ganga.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductId {
	
	@Column(name="order_id")
	public int orderId;
	
	@Column(name="product_id")
	public int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	public OrderProductId(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	public OrderProductId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
