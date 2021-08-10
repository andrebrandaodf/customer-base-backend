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

import com.gs3.models.Client;
import com.gs3.repository.ClientRepository;
import com.gs3.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientRepository clientRepository;

	@PostMapping("/client")
	@ResponseStatus(HttpStatus.CREATED)
	public Client addClient(@Valid @RequestBody Client client) {
		String cpf = "";
		if (client.getCpf() != null) {
			client.getCpfComMascara(cpf);
		}
		return clientService.saveClient(client);
	}

	@GetMapping("/client")
	public List<Client> findAll() {
		return clientService.getClient();
	}

	@GetMapping("/client/{id}")
	public Client findClientById(@PathVariable Long id) {
		return clientService.getClientById(id);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@Valid @PathVariable Long id, @RequestBody Client client) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		client.setId(id);
		client = clientService.saveClient(client);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		clientService.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
}
