package com.mislata.hospital.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mislata.hospital.model.dto.MedicamentoDTO;
import com.mislata.hospital.service.MedicamentoService;

@RestController
@RequestMapping("/api")
public class MedicamentoRestController {
	
	@Autowired
	MedicamentoService medicamentoService;
	
	@GetMapping("/medicamentos")
	public List<MedicamentoDTO> getMedicamentos(){
		return medicamentoService.getMedicamentos();
	}

	@GetMapping("/medicamentos/{id}")
	public MedicamentoDTO getMedicamentoById(@PathVariable("id") Integer id) {
		return medicamentoService.getMedicamentoById(id);
	}
	
	@PostMapping("/medicamentos")
	public MedicamentoDTO insertMedicamento(@RequestBody MedicamentoDTO medicamentoDTO) {
		
		return medicamentoService.insertMedicamento(medicamentoDTO);
		
	}
	
	@PutMapping("/medicamentos/{id}")
	public MedicamentoDTO updateMedicamento(@PathVariable("id") Integer id, @RequestBody  MedicamentoDTO medicamentoDTO) {
		medicamentoDTO.setId(id);
		return medicamentoService.updateMedicamento(medicamentoDTO);
	}
	
	@DeleteMapping("/medicamentos/{id}")
	public void deleteMedicamento(@PathVariable("id") Integer id) {
		
		medicamentoService.deleteMedicamento(id);
	}
}
