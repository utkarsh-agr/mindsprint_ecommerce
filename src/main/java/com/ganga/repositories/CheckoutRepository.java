package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer>{

}
