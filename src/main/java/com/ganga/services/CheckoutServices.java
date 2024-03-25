package com.ganga.services;

import java.security.Principal;

import com.ganga.payloads.BillReturn;

public interface CheckoutServices {
	
	public BillReturn checkout(Principal principal);

}
