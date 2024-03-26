package com.ganga.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.entities.Category;
import com.ganga.entities.Products;
import com.ganga.exceptions.ResourceNotFoundException;
import com.ganga.payloads.ProductDto;
import com.ganga.repositories.CategoryRepository;
import com.ganga.repositories.ProductRepository;
import com.ganga.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDto> getAllProducts() {
		List<Products> products=this.productRepository.findAll();
		return products.stream().map(e->this.productToDto(e)).collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductById(int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		return this.productToDto(product);
	}

	@Override
	public void removeProductById(int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		this.productRepository.delete(product);
	}

	@Override
	public ProductDto AddProduct(ProductDto productDto, int categoryId) {
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		Products product=this.dtoToProduct(productDto);
		product.setProductCategory(category);
		this.productRepository.save(product);
		return this.productToDto(product);
		
	}


	@Override
	public ProductDto updateQuantity(long newQuantity, int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		product.setProductQuantity(newQuantity);
		this.productRepository.save(product);
		return this.productToDto(product);
	}

	@Override
	public ProductDto updateProductName(String newName, int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		product.setProductName(newName);
		this.productRepository.save(product);
		return this.productToDto(product);
	}

	@Override
	public ProductDto updateAmount(double newAmount, int productId) {
		Products product=this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
		product.setProductPrice(newAmount);
		this.productRepository.save(product);
		return this.productToDto(product);
	}
	
	@Override
	public List<ProductDto> getByProductCategory(int categoryId) {
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Id", categoryId));
		List<Products> productLists=this.productRepository.findByProductCategory(category).get();
		return productLists.stream().map(e->this.productToDto(e)).collect(Collectors.toList());
	}
	
	public ProductDto productToDto(Products prod) {
		return this.modelMapper.map(prod, ProductDto.class);
	}
	
	public Products dtoToProduct(ProductDto productDto) {
		return this.modelMapper.map(productDto, Products.class);
	}

	
}
