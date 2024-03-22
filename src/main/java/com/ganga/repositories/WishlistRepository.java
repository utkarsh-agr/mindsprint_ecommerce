package com.ganga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.User;
import com.ganga.entities.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	
	Optional<List<Wishlist>> findByWishlistUser(User user);

}
