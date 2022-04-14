package com.mislata.hospital.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	
	@Column(nullable = false)
	private String nombreRol;
	private String descripcion;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Usuario> usuarios;
}
