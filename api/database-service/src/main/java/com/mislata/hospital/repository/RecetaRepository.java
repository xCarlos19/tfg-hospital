package com.mislata.hospital.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mislata.hospital.model.Receta;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Integer> {

	@Query(value = "select m.nombre  from medicamento m, receta r , receta_medicamentos rm where r.id_receta = rm.id_receta and m.id_medicamento = rm.id_medicamento and r.id_receta = :id", nativeQuery = true)
	public Set<String> getMedicamentosReceta(@Param("id") Integer id);
	
	@Query(value="select * from receta r, sanitario s, usuario u, usuario_sanitario us where r.id_sanitario = s.id_sanitario and s.id_sanitario = us.id_sanitario and us.id_usuario = u.id_usuario and u.nombre_usuario = :username ORDER BY r.fecha_creacion DESC", nativeQuery = true)
	public List<Receta> getRecetaByUsername(@Param("username") String username);
}
