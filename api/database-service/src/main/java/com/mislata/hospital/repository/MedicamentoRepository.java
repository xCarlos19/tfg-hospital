package com.mislata.hospital.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mislata.hospital.model.Medicamento;

@Repository
public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
	
	@Query("Select m from Medicamento m Where m.nombre = :nombre")
	public Medicamento getMedicamentoByName(@Param("nombre")String nombre);
	
	//Elimino las relaciones entre medicamentos y recetas
	@Query(value="DELETE FROM receta_medicamentos WHERE id_medicamento = :id", nativeQuery = true)
	@Transactional
	@Modifying
	public void deleteMedicamentoJoinById(@Param("id") Integer id);

}
