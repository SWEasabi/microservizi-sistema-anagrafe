package com.SWEasabi.gestione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Lampione;

@RestController
public class LampController {
	
	@Autowired
	CoreGestione core;
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	//@RequestMapping(value = "/lamp/{id}", method = RequestMethod.GET, produces="application/json")
	@GetMapping("lamp/{id}")
	public Lampione getLamp(@PathVariable int id)
	{
		return core.getLamp(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/allLamps")
	public List<Lampione> getAllLamps()
	{
		return core.getLamps();
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/LampsInArea/{idArea}")
	public List<Lampione> getLampsInArea(@PathVariable int idArea)
	{
		return core.getLampsInArea(idArea);
	}

	public record LampInsertInput (int idArea, double latitudine, double longitudine, String tipo, int voltaggio) {}

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/insert")
	public boolean addLamp(@RequestBody LampInsertInput data)
	{
		return core.addLamp(data.idArea(), data.latitudine(), data.longitudine(), data.tipo(), data.voltaggio());
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/delete/{id}")
	public boolean deleteLamp(@PathVariable int id)
	{
		return core.deleteLamp(id);
	}
}
