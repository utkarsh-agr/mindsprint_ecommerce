package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Integer> {

}
