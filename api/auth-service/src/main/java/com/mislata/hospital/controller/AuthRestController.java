package com.mislata.hospital.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mislata.hospital.model.JwtToken;
import com.mislata.hospital.model.Usuario;
import com.mislata.hospital.model.dto.DatosLoginDTO;
import com.mislata.hospital.service.JwtTokenUtil;

@RestController
@RequestMapping("/api")

public class AuthRestController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public Object getUsuarios(@RequestBody DatosLoginDTO datosLogin){
		//Autenticamos al usuario con usuario y contraseña(debe estar encriptada en la BBDD)
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						datosLogin.getUsername(),
						datosLogin.getPassword()));
		
		//Creamos un usuarioDetails que nos servirá para crear el token y para devolver los roles
		UserDetails userDetails = userDetailsService.loadUserByUsername(datosLogin.getUsername());
		
		//Generamos el token
		String token = jwtTokenUtil.generateToken(userDetails);
		
		//Devolvemos en este caso, token, username y roles (Se puede devolver los campos que deseemos)
		
		return new JwtToken(token, datosLogin.getUsername(), ((Usuario) userDetails).getRoles().stream().map((rol -> rol.getNombreRol())).collect(Collectors.toList()));
		
	}

}
