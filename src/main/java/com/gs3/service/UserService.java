package com.gs3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs3.models.User;
import com.gs3.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	public User saveUser(User user) {
		return repository.save(user);
	}

	public List<User> saveUser(List<User> user) {
		return repository.saveAll(user);
	}

	public List<User> getUser() {
		return repository.findAll();
	}

	public User getUserById(Long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public User getUserByName(String nome) {
		return repository.findByName(nome);
	}

	@Transactional
	public User updateuser(User user) {
		User existUser = repository.findById(user.getId()).orElse(null);
	
		existUser.setName(user.getName());
		existUser.setCpf(user.getCpf());
		existUser.setPhone(user.getPhone());
		existUser.setEmail(user.getEmail());
		addressService.updateAddress(user.getAddress());
		return repository.save(existUser);		
	}
	
	@Transactional
	public String deleteUser(Long id) {
		repository.deleteById(id);
		return "user removido!" + id;
	}
	
}
