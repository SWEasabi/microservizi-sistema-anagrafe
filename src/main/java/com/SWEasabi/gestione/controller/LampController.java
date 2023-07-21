package com.SWEasabi.gestione.controller;

import java.util.List;

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
public class LampController {
	
	@Autowired
	CoreGestione core;
	
	@GetMapping("lamp/{id}")
	public String getLamp(@PathVariable int id)
	{
		return core.getLamp(id).toString();
	}
	
	@GetMapping("lamp/allLamps")
	public String getAllLamps()
	{
		List<JsonObject> list = core.getLamps();
		String res = "";
		for(JsonObject o : list)
		{
			res += o.toString();
		}
		return res;
	}
	
	@GetMapping("lamp/LampsInArea/{idArea}")
	public String getLampsInArea(@PathVariable int idArea)
	{
		List<JsonObject> list = core.getLampsInArea(idArea);
		String res = "";
		for(JsonObject o : list)
		{
			res += o.toString();
		}
		return res;
	}
	
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
	
	@PutMapping("lamp/delete/{id}")
	public boolean deleteLamp(@PathVariable int id)
	{
		return core.deleteLamp(id);
	}
}
