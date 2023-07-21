package com.SWEasabi.gestione.repositories;

import org.springframework.data.repository.CrudRepository;
import com.SWEasabi.gestione.entities.Sensore;

public interface SensorRepository extends CrudRepository<Sensore, Long> {
	public Sensore findById(long id);
	public Sensore findByIdmisuratore(long id);
	public boolean deleteById(long id);
}
