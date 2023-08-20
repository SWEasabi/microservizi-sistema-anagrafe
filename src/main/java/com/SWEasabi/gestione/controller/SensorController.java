package com.SWEasabi.gestione.controller;

import com.SWEasabi.gestione.entities.Sensore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.DTO.SensorDTO;
import com.SWEasabi.gestione.core.CoreGestione;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

@RestController
public class SensorController {
	
	CoreGestione core;
	
	public SensorController(CoreGestione core) {
		this.core=core;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/{id}")
	public SensorDTO getsensor(@PathVariable int id)
	{
		Sensore sensore =  core.getSensor(id);
		if(sensore != null) {
			return new SensorDTO(sensore.getId(),
					sensore.getMisuratore().getArea().getId(),
					sensore.getMisuratore().getLatitudine(),
					sensore.getMisuratore().getLongitudine(),
					sensore.getRaggio());
		}
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/allSensors")
	public List<SensorDTO> getAllsensors()
	{
		List<Sensore> sensors = core.getSensors();
		List<SensorDTO> dtoList = new ArrayList<SensorDTO>();
		for(Sensore sensore : sensors) {
			SensorDTO dto = new SensorDTO(sensore.getId(),
					sensore.getMisuratore().getArea().getId(),
					sensore.getMisuratore().getLatitudine(),
					sensore.getMisuratore().getLongitudine(),
					sensore.getRaggio());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/sensorsInArea/{idArea}")
	public List<SensorDTO> getsensorsInArea(@PathVariable int idArea)
	{
		List<Sensore> sensors = core.getSensorsInArea(idArea);
		List<SensorDTO> dtoList = new ArrayList<SensorDTO>();
		for(Sensore sensore : sensors) {
			SensorDTO dto = new SensorDTO(sensore.getId(),
					sensore.getMisuratore().getArea().getId(),
					sensore.getMisuratore().getLatitudine(),
					sensore.getMisuratore().getLongitudine(),
					sensore.getRaggio());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("sensor/insert")
	public boolean addsensor(@RequestBody String data)
	{
		try {
			JsonObject rq = new Gson().fromJson(data, JsonObject.class);
			int idArea = Integer.parseInt(rq.get("idarea").toString());
	    	double latitudine = Double.parseDouble(rq.get("latitudine").toString());
	    	double longitudine = Double.parseDouble(rq.get("longitudine").toString());
	    	String tipo = "sensore";
	    	int raggio = Integer.parseInt(rq.get("raggio").toString());
	    	
	    	return core.addSensor(idArea, latitudine, longitudine, tipo, raggio);
		} catch(JsonSyntaxException e) {
			System.out.println("test");
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("sensor/delete/{id}")
	public boolean deletesensor(@PathVariable int id)
	{
		return core.deleteSensor(id);
	}
}
