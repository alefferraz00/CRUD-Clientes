package com.crud.clientes.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.clientes.model.Cliente;
import com.crud.clientes.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes/lista")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping("/cliente/add")
	@ResponseStatus
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PostMapping("/cliente/atualizar")
	public Cliente atualizar(@PathVariable Long id, Cliente cliente) {
	  clienteRepository.getOne(id);
	  return clienteRepository.save(cliente);
		
	}
	
	@DeleteMapping("/cliente/delete")
	public void delete (@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	
	
	
	
}
