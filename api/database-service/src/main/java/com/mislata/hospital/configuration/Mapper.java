package com.mislata.hospital.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mislata.hospital.model.Medicamento;
import com.mislata.hospital.model.Receta;
import com.mislata.hospital.model.dto.MedicamentoDTO;
import com.mislata.hospital.model.dto.RecetaDTO;
import com.mislata.hospital.model.dto.RecetaInsertDTO;
import com.mislata.hospital.repository.MedicamentoRepository;
import com.mislata.hospital.repository.PacienteRepository;
import com.mislata.hospital.repository.RecetaRepository;
import com.mislata.hospital.repository.SanitarioRepository;
import com.mislata.hospital.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Mapper {
	@Autowired
	MedicamentoRepository medicamentoRepository;
	@Autowired
	RecetaRepository recetaRepository;

	@Autowired
	SanitarioRepository sanitarioRepository;

	@Autowired

	UsuarioRepository usuarioRepository;

	@Autowired

	PacienteRepository pacienteRepository;

	public MedicamentoDTO toMedicamentoDTO(Medicamento medicamento) {

		return new MedicamentoDTO(medicamento.getIdMedicamento(), medicamento.getNombre(), medicamento.getDescripcion(),
				medicamento.getFabricante());
	}

	public Medicamento toMedicamento(MedicamentoDTO medicamentoDTO) {

		return new Medicamento(medicamentoDTO.getId(), medicamentoDTO.getNombre(), medicamentoDTO.getDescripcion(),
				medicamentoDTO.getFabricante(), null);

	}

	public RecetaDTO toRecetaDTO(Receta receta) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm");
		Set<String> medicamentosReceta = recetaRepository.getMedicamentosReceta(receta.getIdReceta());

		return new RecetaDTO(receta.getIdReceta(), receta.getDescripcion(),

				receta.getSanitario().getNombre(),

				receta.getPaciente().getNombre(), receta.getFechaCreacion().format(formatter), medicamentosReceta);
	}

	public Receta toReceta(RecetaInsertDTO recetaInsertDTO) {
		Set<Medicamento> medicamentos = new HashSet<>();
		log.info("Medicamentos{}", recetaInsertDTO.getIdsMedicamentos());

		for (MedicamentoDTO m : recetaInsertDTO.getIdsMedicamentos()) {
			medicamentos.add(this.toMedicamento(m));
		}

		  
		return new Receta(null, recetaInsertDTO.getDescripcion(), LocalDateTime.now(),
				usuarioRepository.getUsuarioByUsername(recetaInsertDTO.getNombreUsuario()).getSanitario(),
				pacienteRepository.findById(recetaInsertDTO.getIdPaciente()).get(), medicamentos);
	}

}
