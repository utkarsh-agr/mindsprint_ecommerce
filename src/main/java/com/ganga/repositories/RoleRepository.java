package com.ganga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
