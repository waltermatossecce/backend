package com.bolsasdeidead.springboot.backend.apirest.service;


import com.bolsasdeidead.springboot.backend.apirest.models.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
