package com.ganga.services;

import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.PaymentDto;

public interface PaymentServices {
	
	public ApiResponse createPayment(PaymentDto paymentDto, int checkoutId);
}
