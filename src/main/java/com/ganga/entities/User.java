package com.ganga.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user_details")
public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	
	@Column(name="user_fullname", nullable=false,length = 100)
	private String userFullName;
	
	@Column(unique = true, nullable=false)
	private String userEmail;
	
	@Column(nullable=false)
	private String userPassword;
	
	@Column(nullable=true)
	private String userPhone;
	
	@Column(nullable=true)
	private int userAge;
	
	@Column(nullable=true)
	private String userGender;
	
	@Column(nullable=true)
	private String userPicUrl;
	
	@OneToMany(mappedBy = "cartUser", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<CartProduct> cartProducts=new ArrayList<>();
	
	@OneToMany(mappedBy = "userAddress", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Address> userAddress=new ArrayList<>();
	
	@OneToMany(mappedBy = "wishlistUser", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Wishlist> userWishlists=new ArrayList<>();
	
	@OneToMany(mappedBy = "ratedByUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rating> userRating=new ArrayList<>();
	
	@OneToMany(mappedBy = "orderUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Order> userOrders=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "roleId"))
	private Set<Role> userRoles=new HashSet<>();
	
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPicUrl() {
		return userPicUrl;
	}

	public void setUserPicUrl(String userPicUrl) {
		this.userPicUrl = userPicUrl;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}
	
	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public List<Wishlist> getUserWishlists() {
		return userWishlists;
	}

	public void setUserWishlists(List<Wishlist> userWishlists) {
		this.userWishlists = userWishlists;
	}

	public List<Address> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<Address> userAddress) {
		this.userAddress = userAddress;
	}
	
	

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	

	public List<Order> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Order> userOrders) {
		this.userOrders = userOrders;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities= this.userRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		
		return this.userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
	

}
