package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Lampione;

public interface LampRepository extends CrudRepository<Lampione, Long> {

	public Lampione findById(long id);
	public List<Lampione> findAll();
	//public Lampione findByIdmisuratore(long id);
	public void deleteById(long id);
}
