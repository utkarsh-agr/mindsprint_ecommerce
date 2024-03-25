package com.ganga.payloads;


import jakarta.validation.constraints.NotEmpty;

public class AddressDto {
	
	public int buyerAddressId;
	
	@NotEmpty(message = "Please Enter the name of the buyer")
	public String buyerName;
	
	@NotEmpty(message = "Please Enter the address")
	public String buyerAddress;
	
	@NotEmpty(message = "Please Enter the Phone number of the Buyer")
	public String buyerPhone;
	

	public String buyerType;
	
	public boolean addressDefault;

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


	

	public boolean isAddressDefault() {
		return addressDefault;
	}

	public void setAddressDefault(boolean addressDefault) {
		this.addressDefault = addressDefault;
	}
	
	

	public AddressDto(int buyerAddressId, @NotEmpty(message = "Please Enter the name of the buyer") String buyerName,
			@NotEmpty(message = "Please Enter the address") String buyerAddress,
			@NotEmpty(message = "Please Enter the Phone number of the Buyer") String buyerPhone, String buyerType,
			boolean addressDefault) {
		super();
		this.buyerAddressId = buyerAddressId;
		this.buyerName = buyerName;
		this.buyerAddress = buyerAddress;
		this.buyerPhone = buyerPhone;
		this.buyerType = buyerType;
		this.addressDefault = addressDefault;
	}

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
