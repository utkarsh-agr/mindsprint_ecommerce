package com.ganga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.PaymentDto;
import com.ganga.services.PaymentServices;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentServices paymentServices;
	
	@PostMapping("/{checkoutId}/pay")
	public ResponseEntity<ApiResponse> createPayment(@RequestBody PaymentDto paymentDto, @PathVariable(name="checkoutId") int checkoutId){
		return ResponseEntity.ok(this.paymentServices.createPayment(paymentDto, checkoutId));
	}

}
