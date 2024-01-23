package com.bolsasdeidead.springboot.backend.apirest.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsasdeidead.springboot.backend.apirest.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	
	//public Usuario findByUsernameAndEmail(String Username);
//    @Query("select u from Usuario u.where u.username=?1 and u.otro=2") 
//	public Usuario findByUsername(String Username,String otro);
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername(String Username);
}
