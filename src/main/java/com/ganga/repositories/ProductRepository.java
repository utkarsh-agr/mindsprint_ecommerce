package com.ganga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Category;
import com.ganga.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	Optional<List<Products>> findByProductCategory(Category category);

}
