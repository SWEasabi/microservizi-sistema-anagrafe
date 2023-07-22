package com.SWEasabi.gestione.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.google.gson.JsonObject;

@SpringBootTest
class JsonBuilderServiceTest {
	
	@Autowired
	JsonBuilderService jsonBuilder;

	/*@Test
	void buildLampJsonTest() {
		Lampione lampione = new Lampione(1,10);
		Misuratore misuratore = new Misuratore(1,"lampione",10.0,20.0);
		JsonObject json = new JsonObject();
		json.addProperty("id", lampione.getId());
		json.addProperty("idArea", misuratore.getIdArea());
		json.addProperty("voltaggio", lampione.getVoltaggio());
		json.addProperty("latitudine", misuratore.getLatitudine());
		json.addProperty("longitudine", misuratore.getLongitudine());
		
		JsonObject testJson = jsonBuilder.buildLampJson(lampione);
		
		assertEquals(json,testJson);
		}
	
	@Test
	void buildSensorJsonTest() {
		Sensore sensore = new Sensore(1,10);
		Misuratore misuratore = new Misuratore(1,"lampione",10.0,20.0);
		JsonObject json = new JsonObject();
		json.addProperty("id", sensore.getId());
		json.addProperty("idMisuratore", sensore.getIdMisuratore());
		json.addProperty("idArea", misuratore.getIdArea());
		json.addProperty("raggio", sensore.getRaggio());
		json.addProperty("latitudine", misuratore.getLatitudine());
		json.addProperty("longitudine", misuratore.getLongitudine());
		
		JsonObject testJson = jsonBuilder.buildSensorJson(sensore,misuratore);
		
		assertEquals(json,testJson);
		}
		*/
}
