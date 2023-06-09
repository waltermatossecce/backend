package com.bolsadeideas.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.Cliente;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(path = "api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente>index(){
		return clienteService.findAll();
	}
	@GetMapping("/clientes/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	@PostMapping("/clientes")
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	@PutMapping("/clientes/{id}")
	public Cliente update(@PathVariable Long id,@RequestBody Cliente cliente) {
		
		Cliente clienteActual=clienteService.findById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	@DeleteMapping("/clientes/{id}")
	public void destroy(@PathVariable Long id) {
		clienteService.delete(id);
	}
}
