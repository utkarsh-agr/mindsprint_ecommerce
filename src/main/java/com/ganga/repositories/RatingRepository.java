package com.ganga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ganga.entities.Ids.ProductUserId;
import com.ganga.entities.Products;
import com.ganga.entities.Rating;
import com.ganga.entities.User;

public interface RatingRepository extends JpaRepository<Rating, ProductUserId> {
	
	Optional<List<Rating>> findByRatedProduct(Products product);
	Optional<List<Rating>> findByRatedByUser(User user);

}
