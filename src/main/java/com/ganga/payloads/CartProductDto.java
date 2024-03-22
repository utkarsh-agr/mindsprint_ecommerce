package com.ganga.payloads;

import com.ganga.entities.Ids.ProductUserId;

public class CartProductDto {
	
	public ProductUserId productUserId;
	
	public int productQuantity;
	
	public boolean select;

	public ProductUserId getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(ProductUserId productUserId) {
		this.productUserId = productUserId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public CartProductDto(ProductUserId productUserId, int productQuantity, boolean select) {
		super();
		this.productUserId = productUserId;
		this.productQuantity = productQuantity;
		this.select = select;
	}

	public CartProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
