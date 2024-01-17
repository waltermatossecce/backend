package com.bolsasdeidead.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;
import com.bolsasdeidead.springboot.backend.apirest.models.Modalidad;
import com.bolsasdeidead.springboot.backend.apirest.repositorio.IAlumnoRepository;


@Service
public class AlumnoServiceImpl implements AlumnoService {

	
	@Autowired
	private IAlumnoRepository alumnoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(int id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
	  alumnoRepository.deleteById(id);	
	}

	@Override
	public List<Modalidad> findAllModalidad() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAllModalidad();
	}
	
}
