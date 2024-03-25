package com.ganga.services.impl;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.configs.AppConstants;
import com.ganga.entities.Address;
import com.ganga.entities.CartProduct;
import com.ganga.entities.Checkout;
import com.ganga.entities.User;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.BillReturn;
import com.ganga.repositories.AddressRepository;
import com.ganga.repositories.CartProductRepository;
import com.ganga.repositories.CheckoutRepository;
import com.ganga.repositories.UserRepository;
import com.ganga.services.CartProductServices;
import com.ganga.services.CheckoutServices;

@Service
public class CheckoutServicesImpl implements CheckoutServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CheckoutRepository checkoutRepository;
	
	@Autowired
	CartProductRepository cartProductRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public BillReturn checkout(Principal principal) {
		
		int userId=this.userRepository.findByUserEmail(principal.getName()).get().getUserId();
		
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));

		double amount=0;
	
		List<CartProduct> lists=this.cartProductRepository.findByCartUserAndSelect(user, true).get();
				
		for (CartProduct e : lists) {
			amount+=(e.getProductQuantity())*(e.getCartProducts().getProductPrice());
		}
		
		Address address=this.addressRepository.findByUserAddressAndAddressDefault(user, true).orElseThrow(()->new ResourceNotFoundException("Default address", "user", 0));
		
		Checkout checkout=new Checkout();
		checkout.setCheckoutAmount(amount);
		checkout.setCheckoutExtras(AppConstants.SHIPPING_COST);
		
		checkout.setCheckoutAddress(address);
		
		Checkout savedCheckout= this.checkoutRepository.save(checkout);
		
		return new BillReturn(savedCheckout.getCheckoutId(),amount,AppConstants.SHIPPING_COST);
	}

}
