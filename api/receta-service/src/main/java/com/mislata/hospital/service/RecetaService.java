package com.mislata.hospital.service;

import java.util.List;

import com.mislata.hospital.model.dto.RecetaDTO;
import com.mislata.hospital.model.dto.RecetaInsertDTO;

public interface RecetaService {

	public RecetaDTO getRecetaById(Integer id);
	public List<RecetaDTO> getRecetasByUsername(String username);
 	public RecetaDTO insertReceta(RecetaInsertDTO recetaInsertDTO);
}
