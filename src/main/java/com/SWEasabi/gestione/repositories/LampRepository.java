package com.SWEasabi.gestione.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Lampione;

public interface LampRepository extends CrudRepository<Lampione, Long> {

	public Lampione findById(long id);
	public Lampione findByIdmisuratore(long id);
	public boolean deleteById(long id);
}
