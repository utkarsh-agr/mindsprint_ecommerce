package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.OrderDetails;
import com.ganga.entities.Ids.OrderProductId;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderProductId> {

}
