package com.ganga.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.CartProduct;
import com.ganga.entities.Checkout;
import com.ganga.entities.Order;
import com.ganga.entities.OrderDetails;
import com.ganga.entities.Payments;
import com.ganga.entities.Products;
import com.ganga.entities.Ids.OrderProductId;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.PaymentDto;
import com.ganga.repositories.CartProductRepository;
import com.ganga.repositories.CheckoutRepository;
import com.ganga.repositories.OrderDetailsRepository;
import com.ganga.repositories.OrderRepository;
import com.ganga.repositories.PaymentRepository;
import com.ganga.repositories.ProductRepository;
import com.ganga.services.PaymentServices;

@Service
public class PaymentServicesImpl implements PaymentServices {
	
	@Autowired
	CheckoutRepository checkoutRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartProductRepository cartProductRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ApiResponse createPayment(PaymentDto paymentDto, int checkoutId) {
		Checkout checkout=this.checkoutRepository.findById(checkoutId).orElseThrow(()->new ResourceNotFoundException("Checkout", "Id", checkoutId));
		Payments payment=this.dtoToPayments(paymentDto);
		String method=payment.getPaymentMethod();
		
		boolean done=false;
		
		if(method.equals("COD")) {
			done=true;
		}
		else {
			//I will write all my payment gateway integration here
			this.checkoutRepository.delete(checkout);
			return new ApiResponse("Methods other then COD are currently not allowed", false);
		}
		
		if(!done)
			return new ApiResponse("Payment not successful", false);
		
		payment.setPaymentAmount(checkout.getCheckoutTotal());
		payment.setPaymentDate(new Date());
		
		//Creating a order
		Order order=new Order();
		order.setOrderAmount(checkout.getCheckoutAmount());
		order.setOrderDate(new Date());
		order.setOrderUser(checkout.getCheckoutUser());
		this.orderRepository.save(order);
		
		//saving payment to database
		payment.setPaymentForOrder(order);
		this.paymentRepository.save(payment);
		
		//Filling all OrderDetailsTable
		List<CartProduct> lists= this.cartProductRepository.findByCartUserAndSelect(checkout.getCheckoutUser(), true).get();
		System.out.println("Length: "+lists.size());
		for (CartProduct cartProduct : lists) {
			System.out.println("I entered");
			Products product=cartProduct.getCartProducts();
			System.out.println(1);
			OrderDetails ord=new OrderDetails();
			System.out.println(2);
			ord.setOrderProductId(new OrderProductId(order.getOrderId(), product.getProductId()));
			System.out.println(3);
			ord.setProductName(product.getProductName());
			System.out.println(4);
			ord.setProductPrice(product.getProductPrice());
			System.out.println(5);
			ord.setProductQuantity(cartProduct.getProductQuantity());
			System.out.println(6);
			this.orderDetailsRepository.save(ord);
			System.out.println(7);
			product.setProductQuantity(product.getProductQuantity()- cartProduct.getProductQuantity());
			System.out.println(8);
			this.productRepository.save(product);
			System.out.println(9);
		}
		
		this.cartProductRepository.deleteAll(lists);
		
		this.checkoutRepository.delete(checkout);
		
		return new ApiResponse("Order Done", true);
	}
	
	public Payments dtoToPayments(PaymentDto paymentDto) {
		return this.modelMapper.map(paymentDto, Payments.class);
	}
	
	public PaymentDto PaymentsToDto(Payments payments) {
		return this.modelMapper.map(payments, PaymentDto.class);
	}
	
	

}
