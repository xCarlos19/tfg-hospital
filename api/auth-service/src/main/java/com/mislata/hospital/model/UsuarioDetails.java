package com.mislata.hospital.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsuarioDetails extends Usuario implements UserDetails {

	
	private static final long serialVersionUID = 1699541201835468960L;

	public UsuarioDetails() {

	}

	public UsuarioDetails(Usuario usuario) {
		super.setNombreUsuario(usuario.getNombreUsuario());
		super.setPassword(usuario.getPassword());
		super.setRoles(usuario.getRoles());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.info("ROLES:{}", super.getRoles());
		return super.getRoles().stream().map((rol) -> new SimpleGrantedAuthority(rol.getNombreRol()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {

		return super.getNombreUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
