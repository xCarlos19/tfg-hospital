package com.mislata.hospital.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecetaInsertDTO {
	
	private String descripcion;
	private Integer idPaciente;
	private String nombreUsuario;
	private Set<MedicamentoDTO> idsMedicamentos;

}
