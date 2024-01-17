package com.bolsasdeidead.springboot.backend.apirest.service;

import java.util.List;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;
import com.bolsasdeidead.springboot.backend.apirest.models.Modalidad;

public interface AlumnoService {

	public List<Alumno>findAll();
	public Alumno save(Alumno alumno);
	public Alumno findById(int id);
	public void deleteById(int id);
	
	public  List<Modalidad>findAllModalidad();
}
