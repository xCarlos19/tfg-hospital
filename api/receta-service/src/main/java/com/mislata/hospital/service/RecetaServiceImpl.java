package com.mislata.hospital.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mislata.hospital.configuration.Mapper;
import com.mislata.hospital.model.Receta;
import com.mislata.hospital.model.dto.RecetaDTO;
import com.mislata.hospital.model.dto.RecetaInsertDTO;
import com.mislata.hospital.repository.RecetaRepository;

@Service
@Transactional
public class RecetaServiceImpl implements RecetaService{

	@Autowired
	RecetaRepository recetaRepository;
	@Autowired
	Mapper mapper;
	
	@Override
	public RecetaDTO getRecetaById(Integer id) {
		
		return mapper.toRecetaDTO(recetaRepository.findById(id).get());
	}

	@Override
	@Transactional(rollbackFor = SQLException.class)
	public RecetaDTO insertReceta(RecetaInsertDTO recetaInsertDTO) {
		
		
		return mapper.toRecetaDTO(recetaRepository.save( mapper.toReceta(recetaInsertDTO))) ;
	}

	@Override
	public List<RecetaDTO> getRecetasByUsername(String username) {
		List<Receta> recetas = recetaRepository.getRecetaByUsername(username);
		List<RecetaDTO> recetasDTO = new ArrayList<>();
		
		recetas.stream().forEach(rec -> {
			recetasDTO.add(mapper.toRecetaDTO(rec));
		});
		
		
		return recetasDTO;
	}



}
