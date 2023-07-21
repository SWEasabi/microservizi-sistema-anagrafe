package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Misuratore;

public interface MisuratoreRepository extends CrudRepository<Misuratore, Long> {
	
	public Misuratore findById(long id);
	public List<Misuratore> findByIdarea(long idArea);
	public List<Misuratore> findByTipo(String tipo);
	public List<Misuratore> findByTipoAndIdarea(String tipo,long idArea);
	
	public boolean deleteById(long id);
}
