package com.ganga.services;

import java.util.List;

import com.ganga.payloads.AddressDto;

public interface AddressServices {
	
	public AddressDto addAddress(AddressDto addressDto, int userId);
	
	public AddressDto findAddressById(int addressId);
	
	public List<AddressDto> findAddressOfAUser(int userId);
	
	public List<AddressDto> findAllAddress();
	

}
