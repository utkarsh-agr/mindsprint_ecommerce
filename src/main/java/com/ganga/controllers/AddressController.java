package com.ganga.controllers;


import com.ganga.payloads.AddressDto;
import com.ganga.payloads.ApiResponse;
import com.ganga.repositories.UserRepository;
import com.ganga.services.AddressServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    private AddressServices addressService;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/setaddress")
    public AddressDto saveAddress(@RequestBody AddressDto address, Principal principal) {
    	int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
    	System.out.println(userId);
        return addressService.addAddress(address, userId);
    }


    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("addressId") int addressId) {
        return ResponseEntity.ok(addressService.findAddressById(addressId));
    }

    @GetMapping("/my_addresses")
    public ResponseEntity<List<AddressDto>> getAllAddressOfAUser(Principal principal) {
    	int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
        List<AddressDto> list=this.addressService.findAddressOfAUser(userId);
        if(list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    
    @GetMapping("/addresses")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AddressDto>> getAllAddresses(){
    	List<AddressDto> list=this.addressService.findAllAddress();
    	if(list.isEmpty())
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	
    	return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/{addressId}/delete_address")
    public ResponseEntity<ApiResponse> deleteMyAddress(@PathVariable("addressId") Integer addressId, Principal principal){
    	int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
    	return ResponseEntity.ok(this.addressService.deleteMyAddress(addressId, userId));
    }
    
    

}
