package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
