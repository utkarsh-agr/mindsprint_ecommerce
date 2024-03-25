package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
