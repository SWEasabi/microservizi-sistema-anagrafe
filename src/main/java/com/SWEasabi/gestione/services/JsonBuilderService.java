package com.SWEasabi.gestione.services;

import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.google.gson.JsonObject;

public class JsonBuilderService {
	
	public JsonObject buildLampJson(Lampione lampione) {
		JsonObject json = new JsonObject();
		json.addProperty("id", lampione.getId());
		json.addProperty("idArea", lampione.getMisuratore().getIdArea());
		json.addProperty("voltaggio", lampione.getVoltaggio());
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
}