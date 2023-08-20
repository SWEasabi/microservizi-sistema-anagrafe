package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Misuratore;

public interface MisuratoreRepository extends CrudRepository<Misuratore, Long> {
	
	Misuratore findById (long id);
	List<Misuratore> findByArea_id (long idArea);
	List<Misuratore> findByTipo (String tipo);
	List<Misuratore> findByTipoAndArea_id (String tipo, long idArea);
	
	void deleteById (long id);
}
