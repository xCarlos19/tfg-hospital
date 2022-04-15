package com.mislata.hospital.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mislata.hospital.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	@Query("Select u From Usuario u Where u.nombreUsuario = :username")
	public Usuario getUsuarioByUsername(@Param("username") String username);
}
