package com.bolsasdeidead.springboot.backend.apirest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer>{

}
