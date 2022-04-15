package com.mislata.hospital.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(nullable = false)
	private String nombreUsuario;
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_rol",
	joinColumns = @JoinColumn(name="id_usuario"),
	inverseJoinColumns = @JoinColumn(name="id_rol"))
	private Set<Rol> roles;
	
	@OneToOne
	@JoinTable(name="usuario_sanitario",
	joinColumns = @JoinColumn(name="id_usuario"),
	inverseJoinColumns = @JoinColumn(name="id_sanitario"))
	private Sanitario sanitario; 
	 
}
