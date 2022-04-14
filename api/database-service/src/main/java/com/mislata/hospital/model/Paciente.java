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
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPaciente;
	@Column(nullable = false)
	private String nombre;
	private Integer edad;
	
	@OneToMany(mappedBy = "paciente")
	private Set<Receta> recetas;
	
	@OneToOne(mappedBy = "paciente")
	private Usuario usuario;
}
