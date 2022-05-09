package com.mislata.hospital.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecetaDTO {

	private Integer idReceta;
	private String descripcion;
	private String nombreSanitario;
	private String nombrePaciente;
	private String fechaCreacion;
	private Set<String> medicamentos;
	
	
	
	
	
}
