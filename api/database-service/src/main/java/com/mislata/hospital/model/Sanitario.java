package com.mislata.hospital.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sanitario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdSanitario;
	@Column(nullable = false)
	private String nombre;
	private Integer edad;
	
	@OneToMany(mappedBy = "sanitario")
	private Set<Receta> recetas;
	
	@OneToOne(mappedBy = "sanitario")
	private Usuario usuario;
}
