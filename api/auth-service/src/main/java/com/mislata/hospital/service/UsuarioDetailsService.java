package com.mislata.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mislata.hospital.model.Usuario;
import com.mislata.hospital.model.UsuarioDetails;
import com.mislata.hospital.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.getUsuarioByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Nombre de usuario no encontrado");
		}
		
		UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
		
		return usuarioDetails;
	}

}
