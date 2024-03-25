package com.ganga.entities;


import com.ganga.entities.Ids.ProductUserId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartProduct {
	
	@EmbeddedId
	private ProductUserId productUserId;

	@ManyToOne
	@JoinColumn(name="product_id", referencedColumnName = "productId", insertable = false, updatable = false)
	private Products cartProducts;
	

	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId", insertable = false, updatable = false)
	private User cartUser;
	
	@Column(name="product_quantity")
	private int productQuantity;
	
	@Column(name="whether_selected")
	private boolean select;

	

	public Products getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Products cartProducts) {
		this.cartProducts = cartProducts;
	}

	public User getCartUser() {
		return cartUser;
	}

	public void setCartUser(User cartUser) {
		this.cartUser = cartUser;
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
	
	

	public ProductUserId getProductUserId() {
		return productUserId;
	}

	public void setProductUserId(ProductUserId productUserId) {
		this.productUserId = productUserId;
	}

	public CartProduct(Products cartProducts, User cartUser, int productQuantity, boolean select) {
		super();
		this.cartProducts = cartProducts;
		this.cartUser = cartUser;
		this.productQuantity = productQuantity;
		this.select = select;
	}

	public CartProduct() {
		super();
	}
	
	
}
