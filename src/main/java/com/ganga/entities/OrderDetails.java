package com.ganga.entities;

import com.ganga.entities.Ids.OrderProductId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@EmbeddedId
	private OrderProductId orderProductId;
	
	@OneToOne
	@JoinColumn(name="order_id", referencedColumnName = "orderId", insertable = false, updatable = false)
	private Order orderIdForCurrentOrder;
	
	private String productName;
	
	private double productPrice;
	

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

	public OrderProductId getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(OrderProductId orderProductId) {
		this.orderProductId = orderProductId;
	}

	public OrderDetails(OrderProductId orderProductId, Order orderIdForCurrentOrder, String productName,
			double productPrice) {
		super();
		this.orderProductId = orderProductId;
		this.orderIdForCurrentOrder = orderIdForCurrentOrder;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
