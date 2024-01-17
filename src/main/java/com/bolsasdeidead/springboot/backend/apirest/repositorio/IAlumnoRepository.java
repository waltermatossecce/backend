package com.bolsasdeidead.springboot.backend.apirest.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;
import com.bolsasdeidead.springboot.backend.apirest.models.Modalidad;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer>{

	@Query("from Modalidad")
	public List<Modalidad>findAllModalidad();
}
