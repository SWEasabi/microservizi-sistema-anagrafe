package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Area;

public interface AreaRepository extends CrudRepository<Area, Long> {
	
	Area findById (long id);
	List<Area> findAll ();
	void deleteById (long id);
}
