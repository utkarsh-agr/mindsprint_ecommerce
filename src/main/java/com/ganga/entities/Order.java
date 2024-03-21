package com.ganga.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private Date orderDate;
	
	private double orderAmount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User orderUser;
	
	@OneToOne(mappedBy = "paymentForOrder")
	private Payments orderPayments;
	
	@OneToOne(mappedBy = "orderIdForCurrentOrder")
	private OrderDetails orderDetails;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public User getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}
	

	public Payments getOrderPayments() {
		return orderPayments;
	}

	public void setOrderPayments(Payments orderPayments) {
		this.orderPayments = orderPayments;
	}
	
	

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order(int orderId, Date orderDate, double orderAmount, User orderUser) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
		this.orderUser = orderUser;
	}

	public Order() {
		super();
	}
	
	

}
