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

public class AreaController {
	
	@Autowired
	CoreGestione core;
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/{id}")
	public ResponseEntity<Object> getArea(@PathVariable int id)
	{
		Map<String,String> data = core.getArea(id);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/allAreas")
	public ResponseEntity<Object> getArea()
	{
		List<Map<String,String>> list = core.getAreas();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/area/delete/{id}")
	public String deleteArea(@PathVariable int id)
	{
		return Boolean.toString(core.deleteArea(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("area/save")
	public boolean saveArea(@RequestBody String data)
	{
		try {
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		String nome = rq.get("nome").toString();
    	boolean auto = Boolean.parseBoolean(rq.get("automode").toString());
    	int inf = Integer.parseInt(rq.get("lvlinf").toString());
    	int sup = Integer.parseInt(rq.get("lvlsup").toString());
    	
    	return core.saveArea(nome,auto,inf,sup);	
		}
		catch(JsonSyntaxException e)
		{
			return false;
		}
    }
	
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@PutMapping("area/move")
	public boolean moveMeasurer(@RequestBody String data)
	{
		try {
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		int newIdArea = Integer.parseInt(rq.get("newidarea").toString());
    	int idMis = Integer.parseInt(rq.get("idmis").toString());
    	double latitudine = Double.parseDouble(rq.get("latitudine").toString());
    	double longitudine = Double.parseDouble(rq.get("longitudine").toString());
    	
    	return core.moveMeasurer(newIdArea, idMis, latitudine, longitudine);
		}
		catch(JsonSyntaxException e)
		{
			return false;
		}
	}
}
