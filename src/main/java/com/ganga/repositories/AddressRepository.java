package com.ganga.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Address;
import com.ganga.entities.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	Optional<List<Address>> findByUserAddress(User user); //UserOfAddress
}
