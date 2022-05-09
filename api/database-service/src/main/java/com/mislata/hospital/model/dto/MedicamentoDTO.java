package com.mislata.hospital.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoDTO {

	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String fabricante;
}
