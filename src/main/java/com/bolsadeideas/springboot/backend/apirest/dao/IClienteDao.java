package com.bolsadeideas.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

	
}
