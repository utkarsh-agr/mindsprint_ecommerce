package com.ganga.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Checkout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkoutId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User checkoutUser;
	
	private double checkoutAmount;
	
	private double checkoutExtras;
	
	private double checkoutTotal;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address checkoutAddress;
	
	@Column(name="payment_check")
	private boolean isPaymentDone;
	
	private String paymentMethod;
	
	private String paymentDate;

	public int getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(int checkoutId) {
		this.checkoutId = checkoutId;
	}

	public User getCheckoutUser() {
		return checkoutUser;
	}

	public void setCheckoutUser(User checkoutUser) {
		this.checkoutUser = checkoutUser;
	}

	public double getCheckoutAmount() {
		return checkoutAmount;
	}

	public void setCheckoutAmount(double checkoutAmount) {
		this.checkoutAmount = checkoutAmount;
	}

	public double getCheckoutExtras() {
		return checkoutExtras;
	}

	public void setCheckoutExtras(double checkoutExtras) {
		this.checkoutExtras = checkoutExtras;
	}

	public double getCheckoutTotal() {
		return checkoutTotal;
	}

	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}

	public Address getCheckoutAddress() {
		return checkoutAddress;
	}

	public void setCheckoutAddress(Address checkoutAddress) {
		this.checkoutAddress = checkoutAddress;
	}

	public boolean isPaymentDone() {
		return isPaymentDone;
	}

	public void setPaymentDone(boolean isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Checkout(int checkoutId, User checkoutUser, double checkoutAmount, double checkoutExtras,
			double checkoutTotal, Address checkoutAddress, boolean isPaymentDone, String paymentMethod,
			String paymentDate) {
		super();
		this.checkoutId = checkoutId;
		this.checkoutUser = checkoutUser;
		this.checkoutAmount = checkoutAmount;
		this.checkoutExtras = checkoutExtras;
		this.checkoutTotal = checkoutTotal;
		this.checkoutAddress = checkoutAddress;
		this.isPaymentDone = isPaymentDone;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
	}

	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

}
