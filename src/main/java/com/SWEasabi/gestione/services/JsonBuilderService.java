package com.SWEasabi.gestione.services;

import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.google.gson.JsonObject;

public class JsonBuilderService {
	
	public JsonObject buildLampJson(Lampione lampione, Misuratore misuratore) {
		JsonObject json = new JsonObject();
		json.addProperty("id", lampione.getId());
		json.addProperty("idMisuratore", lampione.getIdMisuratore());
		json.addProperty("idArea", misuratore.getIdArea());
		json.addProperty("voltaggio", lampione.getVoltaggio());
		json.addProperty("latitudine", misuratore.getLatitudine());
		json.addProperty("longitudine", misuratore.getLongitudine());
		return json;
	}


	public JsonObject buildSensorJson(Sensore sensore, Misuratore misuratore) {
		JsonObject json = new JsonObject();
		json.addProperty("id", sensore.getId());
		json.addProperty("idMisuratore", sensore.getIdMisuratore());
		json.addProperty("idArea", misuratore.getIdArea());
		json.addProperty("raggio", sensore.getRaggio());
		json.addProperty("latitudine", misuratore.getLatitudine());
		json.addProperty("longitudine", misuratore.getLongitudine());
		return json;
	}
}