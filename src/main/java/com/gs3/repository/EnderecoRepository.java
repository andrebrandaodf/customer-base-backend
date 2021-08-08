package com.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	Optional<Endereco> findById(Long id);

	Endereco findByCep(String cep);
}
