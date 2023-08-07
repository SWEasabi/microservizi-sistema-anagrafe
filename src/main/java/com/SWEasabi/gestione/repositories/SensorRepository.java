package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SWEasabi.gestione.entities.Sensore;

public interface SensorRepository extends CrudRepository<Sensore, Long> {
	Sensore findById (long id);
	List<Sensore> findAll ();
	void deleteById (long id);
}
