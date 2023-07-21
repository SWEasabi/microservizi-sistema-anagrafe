package com.SWEasabi.gestione.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/area/{id}")
	public String getArea(@PathVariable int id)
	{
		return core.getArea(id);
	}
	
	@GetMapping("/area/delete/{id}")
	public String deleteArea(@PathVariable int id)
	{
		return Boolean.toString(core.deleteArea(id));
	}
	
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
	
	@PutMapping("area/move")
	public boolean moveMeasurer(@RequestBody String data)
	{
		try {
		JsonObject rq = new Gson().fromJson(data, JsonObject.class);
		int newIdArea = Integer.parseInt(rq.get("newidarea").toString());
    	int idMis = Integer.parseInt(rq.get("idmis").toString());
    	double newX = Double.parseDouble(rq.get("newx").toString());
    	double newY = Double.parseDouble(rq.get("newy").toString());
    	
    	return core.moveMeasurer(newIdArea, idMis, newX, newY);
		}
		catch(JsonSyntaxException e)
		{
			return false;
		}
	}
}
