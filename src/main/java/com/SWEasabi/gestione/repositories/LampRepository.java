package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Lampione;

public interface LampRepository extends CrudRepository<Lampione, Long> {

	Lampione findById (long id);
	List<Lampione> findAll ();
	//public Lampione findByIdmisuratore(long id);
    void deleteById (long id);
}
