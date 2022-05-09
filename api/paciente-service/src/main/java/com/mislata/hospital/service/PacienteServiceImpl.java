package com.mislata.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mislata.hospital.model.Paciente;
import com.mislata.hospital.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	PacienteRepository pacienteRepository;
	@Override
	public List<Paciente> getPacientes() {
		
		return (List<Paciente>) pacienteRepository.findAll();
	}

	
}
