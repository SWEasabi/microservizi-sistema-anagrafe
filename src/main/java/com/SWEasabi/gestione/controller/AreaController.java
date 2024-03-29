package com.SWEasabi.gestione.controller;

import com.SWEasabi.gestione.entities.Area;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.core.CoreGestione;

@RestController
public class AreaController {
	
	CoreGestione core;
	
	public AreaController(CoreGestione core) {
		this.core=core;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/{id}")
	public Area getArea(@PathVariable int id)
	{
		return core.getArea(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/allAreas")
	public List<Area> getAreas()
	{
		return core.getAreas();
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/delete/{id}")
	public boolean deleteArea(@PathVariable int id)
	{
		return core.deleteArea(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("area/save/{nome}")
	public boolean saveArea(@PathVariable String nome) {
		Area input = new Area();
		input.setNome(nome);
		input.setautomode(false);
		input.setlvlinf(0);
		input.setlvlsup(100);
		return core.saveArea(input);
    }

	public record MoveMeasurerInput (int newidarea, int idmis, double latitudine, double longitudine) {}
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("area/move")
	public boolean moveMeasurer(@RequestBody MoveMeasurerInput data)
	{
    	return core.moveMeasurer(data.newidarea(), data.idmis(), data.latitudine(), data.longitudine());
	}
}
