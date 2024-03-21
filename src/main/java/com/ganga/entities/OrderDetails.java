package com.ganga.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	private int productId;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@Id
	private Order orderIdForCurrentOrder;
	
	private String productName;
	
	private double productPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Order getOrderIdForCurrentOrder() {
		return orderIdForCurrentOrder;
	}

	public void setOrderIdForCurrentOrder(Order orderIdForCurrentOrder) {
		this.orderIdForCurrentOrder = orderIdForCurrentOrder;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public OrderDetails(int productId, Order orderIdForCurrentOrder, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.orderIdForCurrentOrder = orderIdForCurrentOrder;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
