package com.mislata.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mislata.hospital.configuration.Mapper;
import com.mislata.hospital.model.Medicamento;
import com.mislata.hospital.model.Receta;
import com.mislata.hospital.model.dto.MedicamentoDTO;
import com.mislata.hospital.repository.MedicamentoRepository;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	MedicamentoRepository medicamentoRepository;
	@Autowired
	Mapper mapper;

	@Override
	public List<MedicamentoDTO> getMedicamentos() {
		List<Medicamento> medicamentos = (List<Medicamento>)  medicamentoRepository.findAll();
		List<MedicamentoDTO> medicamentosDTO = new ArrayList<>();
		
		
		medicamentos.stream().forEach(m -> medicamentosDTO.add(mapper.toMedicamentoDTO(m)));
		
		return medicamentosDTO;
	}

	@Override
	public MedicamentoDTO getMedicamentoById(Integer id) {

		return mapper.toMedicamentoDTO(medicamentoRepository.findById(id).get());
	}

	@Override
	public MedicamentoDTO insertMedicamento(MedicamentoDTO medicamento) {

		return mapper.toMedicamentoDTO(medicamentoRepository.save(mapper.toMedicamento(medicamento))) ;
	}

	@Override
	public MedicamentoDTO updateMedicamento(MedicamentoDTO medicamento) {

		return mapper.toMedicamentoDTO(medicamentoRepository.save(mapper.toMedicamento(medicamento))) ;
	}

	@Override
	public void deleteMedicamento(Integer id) {
		
		medicamentoRepository.deleteMedicamentoJoinById(id);
		medicamentoRepository.deleteById(id);

	}
	
	

}
