package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.Products;
import com.ganga.entities.Wishlist;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.ApiResponse;
import com.ganga.payloads.WishlistDto;
import com.ganga.repositories.ProductRepository;
import com.ganga.repositories.WishlistRepository;
import com.ganga.services.WishlistServices;

@Service
public class WishlistServicesImpl implements WishlistServices {
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<WishlistDto> getMyWishlists(int userId) {
		List<Wishlist> wishlist= this.wishlistRepository.findAll();
		return wishlist.stream().map(e->this.wishlistToDto(e)).collect(Collectors.toList());
	}

	@Override
	public WishlistDto addAWishlist(WishlistDto wishlistDto) {
		Wishlist wishlist=this.dtoToWishlist(wishlistDto);
		this.wishlistRepository.save(wishlist);
		return wishlistDto;
	}

	@Override
	public ApiResponse deleteAWishlist(int wishlistId, int userId) {
		Wishlist wishlist=this.wishlistRepository.findById(wishlistId).orElseThrow(()->new ResourceNotFoundException("Wishlist", "Id", wishlistId));
		if(wishlist.getWishlistUser().getUserId()!=userId)
			return new ApiResponse("Request Unauthorized",false);
		
		this.wishlistRepository.delete(wishlist);
		return new ApiResponse("Wishlist deleted successfully",true);
	}
	
	public WishlistDto wishlistToDto(Wishlist wishlist) {
		return this.modelMapper.map(wishlist, WishlistDto.class);
	}
	
	public Wishlist dtoToWishlist(WishlistDto wishlistDto) {
		return this.modelMapper.map(wishlistDto, Wishlist.class);
	}

	@Override
	public ApiResponse addAProductToWishList(int wishlistId, int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		Wishlist wishlist=this.wishlistRepository.findById(wishlistId).orElseThrow(()-> new ResourceNotFoundException("WishList", "Id", wishlistId));
		wishlist.getWishlistProducts().add(product);
		this.wishlistRepository.save(wishlist);
		return new ApiResponse("Product Added successfully",true);
	}

	@Override
	public ApiResponse removeAProductFromWishList(int wishlistId, int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		Wishlist wishlist=this.wishlistRepository.findById(wishlistId).orElseThrow(()-> new ResourceNotFoundException("WishList", "Id", wishlistId));
		wishlist.getWishlistProducts().remove(product);
		this.wishlistRepository.save(wishlist);
		return new ApiResponse("Product deleted successfully",true);
	}
	

}
