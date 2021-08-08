package com.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByName(String name);

	Optional<User> findById(Long id);

	void deleteById(Long id);

}
