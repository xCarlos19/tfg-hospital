package com.mislata.hospital.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mislata.hospital.model.Sanitario;

@Repository
public interface SanitarioRepository extends CrudRepository<Sanitario, Integer> {
	
	@Query("Select s From Sanitario s Where s.nombre = :nombre")
	public Sanitario getSanitarioByName(@Param("nombre") String name);
	
	
}
