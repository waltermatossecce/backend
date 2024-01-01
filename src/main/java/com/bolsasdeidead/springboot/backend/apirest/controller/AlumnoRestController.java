package com.bolsasdeidead.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> show(@PathVariable Long id) {
		
		Alumno alumno =null;
		Map<String, Object>resultado = new HashMap<>();
		
		try {
			alumno=alumnoService.findById(id);
		} catch (DataAccessException e) {
			
			resultado.put("mensaje", "Error al realizar la consulta en la base de datos");
			resultado.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		    return new ResponseEntity<Map<String, Object>>(resultado,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (alumno==null) {
			resultado.put("mensaje", "El cliente ID : ".concat(id.toString()).concat(": ").concat(" no existe en la base de datos!"));
		    return new ResponseEntity<Map<String, Object>>(resultado,HttpStatus.NOT_FOUND);
		}
       return new ResponseEntity<Alumno>(alumno,HttpStatus.OK);
    }
	
	@PostMapping("/alumnos")
	public ResponseEntity<?> create(@RequestBody Alumno alumno) {
		
		Alumno nuevoAlumno=null;
         
		Map<String, Object>response = new HashMap<>();
		
		try {
			nuevoAlumno= alumnoService.save(alumno);

		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje","Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		    return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	    response.put("mensaje", "El alumno ha sido creado éxitosamente!");
	    response.put("alumnos", nuevoAlumno);
		
 		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED); 
	}
	@PutMapping("/alumnos/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Alumno alumno) {
		
		
		Alumno obj= alumnoService.findById(id);

		Alumno alumnoupdated = null;
		Map<String, Object>resultado = new HashMap<>();
		
		 if(obj==null) {
		    	resultado.put("mensaje", "El alumno ID :".concat(id.toString().concat(" no existe en la base de datos")));
		        return new ResponseEntity<Map<String, Object>>(resultado,HttpStatus.NOT_FOUND);
		    }
		try {
		    obj.setNombre(alumno.getNombre());
			obj.setApellido(alumno.getApellido());
			obj.setEmail(alumno.getEmail());
			obj.setSexo(alumno.getSexo());
			obj.setDni(alumno.getDni());
			obj.setTelefono(alumno.getTelefono());
			
			alumnoupdated = alumnoService.save(obj);
		} catch (DataAccessException e) {
			
			// TODO: handle exception
			resultado.put("mensaje","Error al actualizar el alumno en la base de datos");
			resultado.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		    return new ResponseEntity<Map<String, Object>>(resultado,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		resultado.put("mensaje", "El alumno ha sido actualizado con éxito!");
		resultado.put("alumno",alumnoupdated);
		return new ResponseEntity<Map<String, Object>>(resultado,HttpStatus.CREATED); 
		
	}
	
	@DeleteMapping("/alumnos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object>response= new HashMap<>();
		try {
			alumnoService.deleteById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje","Error al eliminar el alumno en la base datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		    return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El alumno se elimno éxitosamente!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK); 
	}
}
