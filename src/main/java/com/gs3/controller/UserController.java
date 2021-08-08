package com.gs3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gs3.models.User;
import com.gs3.repository.UserRepository;
import com.gs3.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@Valid @RequestBody User user) {
		String cpf = "";
		if (user.getCpf() != null) {
			user.getCpfComMascara(cpf);
		}
		return userService.saveUser(user);
	}

	@GetMapping("/user")
	public List<User> findAll() {
		return userService.getUser();
	}

	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@Valid @PathVariable Long id, @RequestBody User user) {
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		user.setId(id);
		user = userService.saveUser(user);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		if (!userRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
