package com.ganga.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wishlistId;
	
	@Column(name="wishlist_name")
	private String wishlistName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User wishlistUser;
	
	@ManyToMany
	@JoinTable(name="wishlist_product", joinColumns = {@JoinColumn(name="wishlist_id", referencedColumnName = "wishlistId")}, inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName = "productId")})
	List<Products> wishlistProducts=new ArrayList<>();

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getWishlistName() {
		return wishlistName;
	}

	public void setWishlistName(String wishlistName) {
		this.wishlistName = wishlistName;
	}

	public User getWishlistUser() {
		return wishlistUser;
	}

	public void setWishlistUser(User wishlistUser) {
		this.wishlistUser = wishlistUser;
	}
	
	

	public List<Products> getWishlistProducts() {
		return wishlistProducts;
	}

	public void setWishlistProducts(List<Products> wishlistProducts) {
		this.wishlistProducts = wishlistProducts;
	}

	public Wishlist() {
		super();
	}

	public Wishlist(int wishlistId, String wishlistName, User wishlistUser) {
		super();
		this.wishlistId = wishlistId;
		this.wishlistName = wishlistName;
		this.wishlistUser = wishlistUser;
	}
	
	
}
