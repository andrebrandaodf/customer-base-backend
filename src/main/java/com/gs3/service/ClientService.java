package com.gs3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs3.models.Client;
import com.gs3.models.User;
import com.gs3.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	public Client saveClient(Client client) {
		return repository.save(client);
	}

	public List<Client> saveClient(List<Client> client) {
		return repository.saveAll(client);
	}

	public List<Client> getClient() {
		return repository.findAll();
	}

	public Client getClientById(Long id) {		
		return repository.findById(id).orElse(null);
	}
	
	public Client getClientByName(String name) {
		return repository.findByName(name);
	}

	@Transactional
	public Client updateClient(Client client) {
		Client existClient = repository.findById(client.getId()).orElse(null);
	
		existClient.setName(client.getName());
		existClient.setCpf(client.getCpf());
		existClient.setPhone(client.getPhone());
		existClient.setEmail(client.getEmail());
		addressService.updateAddress(client.getAddress());
		return repository.save(existClient);		
	}
	
	@Transactional
	public String deleteClient(Long id) {
		repository.deleteById(id);
		return "Cliente remove!" + id;
	}
	
}
