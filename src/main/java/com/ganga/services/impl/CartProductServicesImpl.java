package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.CartProduct;
import com.ganga.entities.Category;
import com.ganga.entities.Products;
import com.ganga.entities.User;
import com.ganga.entities.Ids.ProductUserId;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.CartProductDto;
import com.ganga.payloads.CategoryDto;
import com.ganga.repositories.CartProductRepository;
import com.ganga.repositories.ProductRepository;
import com.ganga.repositories.UserRepository;
import com.ganga.services.CartProductServices;

@Service
public class CartProductServicesImpl implements CartProductServices {
	
	@Autowired
	CartProductRepository cartProductRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ApiResponse setProductToCart(CartProductDto cartProductDto,int productId, int userId) {
		CartProduct cartProduct=this.dtoToCartProduct(cartProductDto);
		//System.out.println(cartProduct.getProductQuantity());
		//System.out.println(cartProductDto.getProductQuantity());
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		if(product.getProductQuantity()<(long)cartProductDto.getProductQuantity())
			return new ApiResponse("Higher quantity then the stock available",false);
		cartProduct.setProductUserId(new ProductUserId(productId,userId));
		cartProduct.setCartUser(user);
		cartProduct.setCartProducts(product);
		this.cartProductRepository.save(cartProduct);
		return new ApiResponse("Product Added successfully",true);
	}

	@Override
	public ApiResponse deleteProductFromCart(int productId, int userId) {
		CartProduct cartProduct=this.cartProductRepository.findById(new ProductUserId(productId,userId)).orElseThrow(()-> new ResourceNotFoundException("CartProduct", "Id", 0));
		this.cartProductRepository.delete(cartProduct);
		
		return new ApiResponse("Product Deleted successfully", true);
	}

	@Override
	public ApiResponse increaseQuantityByOne(int productId, int userId) {
		CartProduct cartProduct=this.cartProductRepository.findById(new ProductUserId(productId,userId)).orElseThrow(()-> new ResourceNotFoundException("CartProduct", "Id", 0));
		long stock=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId)).getProductQuantity();
		if(stock==(long)cartProduct.getProductQuantity())
			return new ApiResponse("Out of stock",false);
		
		cartProduct.setProductQuantity(cartProduct.getProductQuantity()+1);
		this.cartProductRepository.save(cartProduct);
		return new ApiResponse("Quantity increased", true);
	}

	@Override
	public ApiResponse decreaseQuantityByOne(int productId, int userId) {
		CartProduct cartProduct=this.cartProductRepository.findById(new ProductUserId(productId,userId)).orElseThrow(()-> new ResourceNotFoundException("CartProduct", "Id", 0));
		int initialQuant=cartProduct.getProductQuantity();
		if(initialQuant==1) {
			this.cartProductRepository.delete(cartProduct);
			return new ApiResponse("Product removed from cart",true);
		}
		cartProduct.setProductQuantity(cartProduct.getProductQuantity()-1);
		this.cartProductRepository.save(cartProduct);
		return new ApiResponse("Quantity decreased", true);
	}
	
	@Override
	public List<CartProductDto> getAllCartProductsForAUser(int userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		List<CartProduct> listOfProducts=this.cartProductRepository.findByCartUser(user).get();
		return listOfProducts.stream().map(e-> this.cartProductToDto(e)).collect(Collectors.toList());
	}
	
	@Override
	public List<CartProductDto> getAllCartProductsForAUserSelected(int userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		List<CartProduct> listOfProducts=this.cartProductRepository.findByCartUserAndSelect(user,true).get();
		return listOfProducts.stream().map(e-> this.cartProductToDto(e)).collect(Collectors.toList());
	}

	
	public CartProductDto cartProductToDto(CartProduct cartProduct) {
		return this.modelMapper.map(cartProduct, CartProductDto.class);
	}
	
	public CartProduct dtoToCartProduct(CartProductDto cartProductDto) {
		return this.modelMapper.map(cartProductDto, CartProduct.class);
	}

	

	

}
