package com.ganga.payloads;

public class WishlistDto {
	
	public int wishlistId;
	public String wishlistName;
	
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
	
	public WishlistDto(int wishlistId, String wishlistName) {
		super();
		this.wishlistId = wishlistId;
		this.wishlistName = wishlistName;
	}
	
	public WishlistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
