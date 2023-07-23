package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SWEasabi.gestione.entities.Sensore;

public interface SensorRepository extends CrudRepository<Sensore, Long> {
	public Sensore findById(long id);
	public List<Sensore> findAll();
	//public Sensore findByIdmisuratore(long id);
	public void deleteById(long id);
}
