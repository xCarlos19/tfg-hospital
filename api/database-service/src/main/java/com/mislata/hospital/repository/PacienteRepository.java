package com.mislata.hospital.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mislata.hospital.model.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
	
	@Query("Select p From Paciente p Where p.nombre = :nombre")
	public Paciente getPacienteByName(@Param("nombre") String name);
	
}
