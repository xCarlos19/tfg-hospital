package com.mislata.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mislata.hospital.model.dto.RecetaDTO;
import com.mislata.hospital.model.dto.RecetaInsertDTO;
import com.mislata.hospital.service.RecetaService;

@RestController
@RequestMapping("/api")
public class RecetaRestController {
	
	@Autowired
	RecetaService recetaService;
	
	@GetMapping("/recetas/{id}")
	public RecetaDTO getRecetaById(@PathVariable("id") Integer id) {
		return recetaService.getRecetaById(id);
	}
	
	@GetMapping("{username}/recetas")
	public List<RecetaDTO> getRecetaByUsername(@PathVariable("username") String username) {
		return recetaService.getRecetasByUsername(username);
	}
	
	@PostMapping("/recetas")
	public RecetaDTO insertReceta(@RequestBody RecetaInsertDTO recetaInsertDTO) {
	
		return recetaService.insertReceta(recetaInsertDTO);
	}
	
	


}
