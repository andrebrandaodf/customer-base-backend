package com.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String nome);

	Optional<Cliente> findById(Long id);

	void deleteById(Long id);

}
