package com.ganga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.CartProduct;
import com.ganga.entities.User;
import com.ganga.entities.Ids.ProductUserId;

public interface CartProductRepository extends JpaRepository<CartProduct, ProductUserId> {
	
	Optional<List<CartProduct>> findByCartUser(User user);

}
