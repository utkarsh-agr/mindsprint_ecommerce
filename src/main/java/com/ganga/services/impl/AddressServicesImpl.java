package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.Address;
import com.ganga.entities.User;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.AddressDto;
import com.ganga.repositories.AddressRepository;
import com.ganga.repositories.UserRepository;
import com.ganga.services.AddressServices;

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
			address.setBuyerAddressDefaultOrNot(true);
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

}
