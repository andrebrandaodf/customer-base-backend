package com.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<Address> findById(Long id);

	Address findByCep(String cep);
}
