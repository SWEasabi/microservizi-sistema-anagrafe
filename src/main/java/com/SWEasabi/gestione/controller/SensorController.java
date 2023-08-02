package com.SWEasabi.gestione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.core.CoreGestione;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

@RestController
public class SensorController {
	
	@Autowired
	CoreGestione core;
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/{id}")
	public ResponseEntity<Object> getsensor(@PathVariable int id)
	{
		Map<String,String> data = core.getSensor(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/allSensors")
	public ResponseEntity<Object> getAllsensors()
	{
		List<Map<String,String>> list = core.getSensors();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("sensor/sensorsInArea/{idArea}")
	public ResponseEntity<Object> getsensorsInArea(@PathVariable int idArea)
	{
		List<Map<String,String>> list = core.getSensorsInArea(idArea);
		return new ResponseEntity<>(list,HttpStatus.OK);
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
	    	int voltaggio = Integer.parseInt(rq.get("raggio").toString());
	    	
	    	return core.addSensor(idArea, latitudine, longitudine, tipo, voltaggio);
		}
		catch(JsonSyntaxException e)
		{
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
