package com.SWEasabi.gestione.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.DTO.LampDTO;
import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Lampione;

@RestController
public class LampController {
	
	CoreGestione core;
	
	public LampController(CoreGestione core) {
		this.core=core;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	//@RequestMapping(value = "/lamp/{id}", method = RequestMethod.GET, produces="application/json")
	@GetMapping("lamp/{id}")
	public LampDTO getLamp(@PathVariable int id)
	{
		Lampione lamp =  core.getLamp(id);
		return new LampDTO(lamp.getId(),
				lamp.getMisuratore().getArea().getId(),
				lamp.getMisuratore().getLatitudine(),
				lamp.getMisuratore().getLongitudine(),
				lamp.getWattaggio(),
				lamp.getLuminosita());
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/allLamps")
	public List<LampDTO> getAllLamps()
	{
		List<Lampione> lamps = core.getLamps();
		List<LampDTO> dtoList = new ArrayList<LampDTO>();
		for(Lampione lamp : lamps) {
			LampDTO dto = new LampDTO(lamp.getId(),
					lamp.getMisuratore().getArea().getId(),
					lamp.getMisuratore().getLatitudine(),
					lamp.getMisuratore().getLongitudine(),
					lamp.getWattaggio(),
					lamp.getLuminosita());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/LampsInArea/{idArea}")
	public List<LampDTO> getLampsInArea(@PathVariable int idArea)
	{
		List<Lampione> lamps = core.getLampsInArea(idArea);
		List<LampDTO> dtoList = new ArrayList<LampDTO>();
		for(Lampione lamp : lamps) {
			LampDTO dto = new LampDTO(lamp.getId(),
					lamp.getMisuratore().getArea().getId(),
					lamp.getMisuratore().getLatitudine(),
					lamp.getMisuratore().getLongitudine(),
					lamp.getWattaggio(),
					lamp.getLuminosita());
			dtoList.add(dto);
		}
		return dtoList;
	}

	public record LampInsertInput (int idarea, double latitudine, double longitudine, String tipo, int wattaggio) {}

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/insert")
	public boolean addLamp(@RequestBody LampInsertInput data)
	{
		return core.addLamp(data.idarea(), data.latitudine(), data.longitudine(), data.tipo(), data.wattaggio());
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/delete/{id}")
	public boolean deleteLamp(@PathVariable int id)
	{
		return core.deleteLamp(id);
	}
}
