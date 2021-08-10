package com.gs3.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByName(String name);

	Optional<Client> findById(Long id);

	void deleteById(Long id);
}
