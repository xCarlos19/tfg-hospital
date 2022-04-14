package com.mislata.hospital.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdReceta;
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="id_sanitario",nullable = false)
	private Sanitario sanitario;
	
	@ManyToOne
	@JoinColumn(name="id_paciente",nullable = false)
	private Paciente paciente;
	
	@ManyToMany
	@JoinTable(
			name = "receta_medicamentos",
			joinColumns = @JoinColumn(name="id_receta"),
			inverseJoinColumns = @JoinColumn(name="id_medicamento"))
	private Set<Medicamento> medicamentos;

}
