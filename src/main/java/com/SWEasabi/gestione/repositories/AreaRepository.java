package com.SWEasabi.gestione.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SWEasabi.gestione.entities.Area;

public interface AreaRepository extends CrudRepository<Area, Long> {
	
	public Area findById(long id);
	public List<Area> findAll();
	public boolean deleteById(long id);
}
