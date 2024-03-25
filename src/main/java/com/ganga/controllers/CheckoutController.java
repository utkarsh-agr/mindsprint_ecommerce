package com.ganga.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.BillReturn;
import com.ganga.services.CheckoutServices;

@RestController
public class CheckoutController {
	
	@Autowired
	CheckoutServices checkoutServices;

	@GetMapping("/checkout")
	public ResponseEntity<BillReturn> checkout(Principal principal){
		return ResponseEntity.ok(this.checkoutServices.checkout(principal));
	}
}
