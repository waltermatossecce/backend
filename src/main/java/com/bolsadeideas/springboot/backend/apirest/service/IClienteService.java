package com.bolsadeideas.springboot.backend.apirest.service;

import java.util.List;



import com.bolsadeideas.springboot.backend.apirest.models.Cliente;

public interface IClienteService {

	public List<Cliente>findAll();
	public Cliente findById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(Long id);
	
}
