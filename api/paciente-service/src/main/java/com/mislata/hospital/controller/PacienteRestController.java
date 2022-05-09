package com.mislata.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mislata.hospital.model.Paciente;
import com.mislata.hospital.service.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteRestController {

	@Autowired
	PacienteService pacienteService;
	
	@GetMapping("/pacientes")
	public List<Paciente> getAllPacientes(){
		return pacienteService.getPacientes();
	}
}
