package com.ganga.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	private double paymentAmount;
	
	private String paymentMethod;
	
	private Date paymentDate;
	
	@OneToOne
	@JoinColumn(name="order_id")
	private Order paymentForOrder;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Order getPaymentForOrder() {
		return paymentForOrder;
	}

	public void setPaymentForOrder(Order paymentForOrder) {
		this.paymentForOrder = paymentForOrder;
	}

	public Payments(int paymentId, double paymentAmount, String paymentMethod, Date paymentDate,
			Order paymentForOrder) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentForOrder = paymentForOrder;
	}

	public Payments() {
		super();
	}
	
	

}
