package com.bolsasdeidead.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsasdeidead.springboot.backend.apirest.models.Alumno;
import com.bolsasdeidead.springboot.backend.apirest.service.AlumnoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(path = "api")
public class AlumnoRestController {
	
	@Autowired
	private AlumnoService alumnoService;
	

	@GetMapping("/alumnos")
	@ResponseStatus(HttpStatus.OK)
	public List<Alumno> index(){
		return alumnoService.findAll();
	}
	
	@GetMapping("/alumnos/{id}")
    public Alumno show(@PathVariable int id) {
       return alumnoService.findById(id);
    }
	
	@PostMapping("/alumnos")
	public Alumno guardarAlumno(@RequestBody Alumno alumno) {
		return alumnoService.save(alumno);
	}
	@PutMapping("/alumnos/{id}")
	public Alumno update(@PathVariable int id,@RequestBody Alumno alumno) {
		
		Alumno obj=alumnoService.findById(id);
		
		
		obj.setNombre(alumno.getNombre());
		obj.setApellido(alumno.getApellido());
		obj.setEmail(alumno.getEmail());
		obj.setSexo(alumno.getSexo());
		obj.setDni(alumno.getDni());
		obj.setTelefono(alumno.getTelefono());
		return alumnoService.save(obj);
		
	}
	
	@DeleteMapping("/alumnos/{id}")
	public void eliminaAlumno(@PathVariable int id) {
		alumnoService.deleteById(id);
	}
}
