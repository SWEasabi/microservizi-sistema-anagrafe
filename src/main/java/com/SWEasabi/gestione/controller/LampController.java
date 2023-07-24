package com.SWEasabi.gestione.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Lampione;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

@RestController
public class LampController {
	
	@Autowired
	CoreGestione core;
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	//@RequestMapping(value = "/lamp/{id}", method = RequestMethod.GET, produces="application/json")
	@GetMapping("lamp/{id}")
	public ResponseEntity<Object> getLamp(@PathVariable int id)
	{
		Map<String,String> data = core.getLamp(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
		//return new ResponseEntity<Object>(json,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/allLamps")
	public ResponseEntity<Object> getAllLamps()
	{
		List<Map<String,String>> list = core.getLamps();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("lamp/LampsInArea/{idArea}")
	public ResponseEntity<Object> getLampsInArea(@PathVariable int idArea)
	{
		List<Map<String,String>> list = core.getLampsInArea(idArea);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/insert")
	public boolean addLamp(@RequestBody String data)
	{
		try {
			JsonObject rq = new Gson().fromJson(data, JsonObject.class);
			int idArea = Integer.parseInt(rq.get("idarea").toString());
	    	double latitudine = Double.parseDouble(rq.get("latitudine").toString());
	    	double longitudine = Double.parseDouble(rq.get("longitudine").toString());
	    	String tipo = "lampione";
	    	int voltaggio = Integer.parseInt(rq.get("voltaggio").toString());
	    	
	    	return core.addLamp(idArea, latitudine, longitudine, tipo, voltaggio);
		}
		catch(JsonSyntaxException e)
		{
			System.out.println("test");
			return false;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("lamp/delete/{id}")
	public boolean deleteLamp(@PathVariable int id)
	{
		return core.deleteLamp(id);
	}
}
