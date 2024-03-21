package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
