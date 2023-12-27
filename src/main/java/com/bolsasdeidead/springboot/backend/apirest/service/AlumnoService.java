package com.bolsasdeidead.springboot.backend.apirest.service;

import java.util.List;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;

public interface AlumnoService {

	public List<Alumno>findAll();
	public Alumno save(Alumno alumno);
	public Alumno findById(int id);
	public void deleteById(int id);
}
