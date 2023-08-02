package com.SWEasabi.gestione.services;

import java.util.HashMap;
import java.util.Map;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Sensore;
import com.google.gson.JsonObject;

public class JsonBuilderService {
	
	public JsonObject buildLampJson(Lampione lampione) {
		JsonObject json = new JsonObject();
		json.addProperty("id", lampione.getId());
		json.addProperty("idArea", lampione.getMisuratore().getIdArea());
		json.addProperty("wattaggio", lampione.getWattaggio());
		json.addProperty("latitudine", lampione.getMisuratore().getLatitudine());
		json.addProperty("longitudine", lampione.getMisuratore().getLongitudine());
		return json;
	}


	public JsonObject buildSensorJson(Sensore sensore) {
		JsonObject json = new JsonObject();
		json.addProperty("id", sensore.getId());
		json.addProperty("idArea", sensore.getMisuratore().getIdArea());
		json.addProperty("raggio", sensore.getRaggio());
		json.addProperty("latitudine", sensore.getMisuratore().getLatitudine());
		json.addProperty("longitudine", sensore.getMisuratore().getLongitudine());
		return json;
	}
	
	public Map<String,String> buildLampMap(Lampione lamp) {
		Map<String, String> data = new HashMap<>();
		data.put("id", Long.toString(lamp.getId()));
		data.put("idarea", Long.toString(lamp.getMisuratore().getIdArea()));
		data.put("latitudine", Double.toString(lamp.getMisuratore().getLatitudine()));
		data.put("longitudine", Double.toString(lamp.getMisuratore().getLongitudine()));
		data.put("wattaggio", Integer.toString(lamp.getWattaggio()));
		
		return data;
	}
	
	public Map<String,String> buildSensorMap(Sensore sensore) {
		Map<String, String> data = new HashMap<>();
		data.put("id", Long.toString(sensore.getId()));
		data.put("idarea", Long.toString(sensore.getMisuratore().getIdArea()));
		data.put("latitudine", Double.toString(sensore.getMisuratore().getLatitudine()));
		data.put("longitudine", Double.toString(sensore.getMisuratore().getLongitudine()));
		data.put("raggio", Integer.toString(sensore.getRaggio()));
		
		return data;
	}
	
	public Map<String,String> buildAreaMap(Area area) {
		Map<String, String> data = new HashMap<>();
		data.put("id", Long.toString(area.getId()));
		data.put("nome", area.getNome());
		data.put("autoMode", Boolean.toString(area.isautomode()));
		data.put("lvlInf", Integer.toString(area.getlvlinf()));
		data.put("lvlSup", Integer.toString(area.getlvlsup()));
		
		return data;
	}
}