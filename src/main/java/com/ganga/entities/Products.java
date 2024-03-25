package com.ganga.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products_details")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="product_name", nullable=false, length = 1000)
	private String productName;
	
	@Column(name="product_price",nullable=true)
	private double productPrice;
	
	@Column(name="product_rating", nullable=true)
	private double productRating;
	
	@Column(name="product_description",length=10000)
	private String productDescription;
	
	@Column(name="product_quantity")
	private long productQuantity;
	
	@Column(name="product_image_url")
	private String productImageUrl;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category productCategory;
	
	@OneToMany(mappedBy = "cartProducts",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	List<CartProduct> cartProducts=new ArrayList<>();

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	
	

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public Products(int productId, String productName, double productPrice, double productRating,
			String productDescription, long productQuantity, String productImageUrl, Category productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productRating = productRating;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productImageUrl = productImageUrl;
		this.productCategory = productCategory;
	}

	
	public Products() {
		super();
	}
	
	
	
	
	
	
	
	
}
