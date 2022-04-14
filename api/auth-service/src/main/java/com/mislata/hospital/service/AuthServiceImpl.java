package com.mislata.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mislata.hospital.model.Usuario;
import com.mislata.hospital.repository.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public List<Usuario> getUsuarios() {
		
		return (List<Usuario>) usuarioRepository.findAll();
	}

}
