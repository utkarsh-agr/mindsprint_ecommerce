package com.ganga.payloads;

public class BillReturn {
	
	public int checkoutId;
	
	public double productAmount;
	
	public double shippingAmount;
	
	public double totalAmount;

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	
	public int getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(int checkoutId) {
		this.checkoutId = checkoutId;
	}

	public BillReturn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillReturn(int checkoutId,double productAmount, double shippingAmount) {
		super();
		this.checkoutId=checkoutId;
		this.productAmount = productAmount;
		this.shippingAmount = shippingAmount;
		this.totalAmount = this.productAmount+this.shippingAmount;
	}
	
	
	

}
