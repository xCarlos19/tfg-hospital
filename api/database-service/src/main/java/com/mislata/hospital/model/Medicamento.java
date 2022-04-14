package com.mislata.hospital.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdMedicamento;
	@Column(nullable = false)
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_sanitario",nullable = false)
	private Sanitario sanitario;
	
	@ManyToMany(mappedBy = "medicamentos")
	private Set<Receta> recetas;
}
