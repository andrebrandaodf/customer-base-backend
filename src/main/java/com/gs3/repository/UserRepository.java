package com.gs3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs3.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);
}
