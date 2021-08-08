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

import com.gs3.models.Cliente;
import com.gs3.repository.ClienteRepository;
import com.gs3.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente addCliente(@Valid @RequestBody Cliente cliente) {
		String cpf ="";
		if (cliente.getCpf() != null) {
		cliente.getCpfComMascara(cpf);
		}
		return clienteService.saveCliente(cliente);
	}
	
	@GetMapping("/clientes")
	public List <Cliente> findAll() {
		return clienteService.getClientes();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente findClienteById(@PathVariable Long id){
		return clienteService.getClienteById(id);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = clienteService.saveCliente(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteService.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
}	
