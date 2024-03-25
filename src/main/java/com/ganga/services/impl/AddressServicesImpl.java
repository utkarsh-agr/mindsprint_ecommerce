package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.configs.AppConstants;
import com.ganga.entities.Address;
import com.ganga.entities.User;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.AddressDto;
import com.ganga.payloads.ApiResponse;
import com.ganga.repositories.AddressRepository;
import com.ganga.repositories.UserRepository;
import com.ganga.services.AddressServices;

import jakarta.transaction.Transactional;

@Service
public class AddressServicesImpl implements AddressServices {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressDto addAddress(AddressDto addressDto, int userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		Address address=this.DtoToAddress(addressDto);
		address.setUserAddress(user);
		if(this.addressRepository.findByUserAddress(user).get().size()==0)
			address.setAddressDefault(true);
		this.addressRepository.save(address);
		return this.addressToDto(address);
	}

	@Override
	public AddressDto findAddressById(int addressId) {
		return this.addressToDto(this.addressRepository.findById(addressId).orElseThrow(()->new ResourceNotFoundException("Address", "Id", addressId)));
	}
	
	@Override
	public List<AddressDto> findAddressOfAUser(int userId) {
		
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "Id", userId));
		List<Address> addresses=this.addressRepository.findByUserAddress(user).orElse(null);

		return addresses.stream().map(e->this.addressToDto(e)).collect(Collectors.toList());
	}

	@Override
	public List<AddressDto> findAllAddress() {
		List<Address> addresses=this.addressRepository.findAll();
		return addresses.stream().map(e->this.addressToDto(e)).collect(Collectors.toList());
	}
	
	public AddressDto addressToDto(Address address) {
		return this.modelMapper.map(address, AddressDto.class);
	}
	
	public Address DtoToAddress(AddressDto addressDto) {
		return this.modelMapper.map(addressDto, Address.class);
	}

	@Override
	public ApiResponse deleteMyAddress(Integer addressId, Integer userId) {
		
		Address ad=this.addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address", "Id", addressId));
		
		//If the address Id does not belong to you, you are unauthorized to delete the address
		if(ad.getUserAddress().getUserId()!=userId)
			return new ApiResponse("Request Unauthorized",false);
					
		boolean flag=false;
		
		if(ad.isAddressDefault())
			flag=true;
		
		
		this.addressRepository.delete(ad);
		
		
		if(flag && !this.addressRepository.findByUserAddress(ad.getUserAddress()).get().isEmpty()) {
			System.out.println(1);
			Address address=this.addressRepository.findByUserAddress(ad.getUserAddress()).get().get(0);
			address.setAddressDefault(true);
			this.addressRepository.save(address);
		}
		
		return new ApiResponse("Address removed successfully",true);
	}

	

}
