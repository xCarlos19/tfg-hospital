package com.mislata.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mislata.hospital.model.Usuario;
import com.mislata.hospital.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthRestController {
	
	@Autowired
	AuthService authService;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return authService.getUsuarios();
	}

}
