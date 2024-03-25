package com.ganga.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buyerAddressId;
	
	@Column(name="user_fullname", nullable=false,length = 100)
	private String buyerName;
	
	@Column(name="user_address", nullable=false,length = 100)
	private String buyerAddress;
	
	@Column(nullable=false)
	private String buyerPhone;
	
	@Column(nullable=true)
	private String buyerType;
	
	@Column(nullable=true)
	private boolean addressDefault;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userAddress ;

	public int getBuyerAddressId() {
		return buyerAddressId;
	}

	public void setBuyerAddressId(int buyerAddressId) {
		this.buyerAddressId = buyerAddressId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}

	

	public User getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(User userAddress) {
		this.userAddress = userAddress;
	}


	public boolean isAddressDefault() {
		return addressDefault;
	}

	public void setAddressDefault(boolean addressDefault) {
		this.addressDefault = addressDefault;
	}
	
	

	public Address(int buyerAddressId, String buyerName, String buyerAddress, String buyerPhone, String buyerType,
			boolean addressDefault, User userAddress) {
		super();
		this.buyerAddressId = buyerAddressId;
		this.buyerName = buyerName;
		this.buyerAddress = buyerAddress;
		this.buyerPhone = buyerPhone;
		this.buyerType = buyerType;
		this.addressDefault = addressDefault;
		this.userAddress = userAddress;
	}

	public Address() {
		super();
	}
	
	
	
	

}
