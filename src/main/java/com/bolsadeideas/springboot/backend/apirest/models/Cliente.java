package com.bolsadeideas.springboot.backend.apirest.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nombre;
	public String apellido;
	public String email;
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	public Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	private static final long serialVersionUID = 1L;
}
