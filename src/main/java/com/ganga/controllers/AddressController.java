package com.ganga.controllers;


import com.ganga.payloads.AddressDto;
import com.ganga.services.AddressServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressServices addressService;

    @PostMapping("/{userId}/address")
    public AddressDto saveAddress(@RequestBody AddressDto address, @PathVariable("userId") int userId) {
        return addressService.addAddress(address, userId);
    }


    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("addressId") int addressId) {
        return ResponseEntity.ok(addressService.findAddressById(addressId));
    }

    @GetMapping("/{userId}/address")
    public ResponseEntity<List<AddressDto>> getAllAddressOfAUser(@PathVariable("userId")int userId) {
        List<AddressDto> list=this.addressService.findAddressOfAUser(userId);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    
    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDto>> getAllAddresses(){
    	List<AddressDto> list=this.addressService.findAllAddress();
    	if(list.isEmpty())
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	
    	return ResponseEntity.ok(list);
    }

}
