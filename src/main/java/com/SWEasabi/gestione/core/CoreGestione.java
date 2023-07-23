package com.SWEasabi.gestione.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.kernel.AreaManager;
import com.SWEasabi.gestione.kernel.LampManager;
import com.SWEasabi.gestione.kernel.SensorManager;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.LampRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.repositories.SensorRepository;
import com.SWEasabi.gestione.services.JsonBuilderService;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;

public class CoreGestione {
	
	@Autowired
	private LampManager lampManager;
	
	@Autowired
	private SensorManager sensorManager;
	
	@Autowired
	private AreaManager areaManager;
	
	@Autowired
	private JsonBuilderService jsonBuilder;
	
	public Map<String,String> getLamp(int id)
	{
		return jsonBuilder.buildLampMap(lampManager.getLamp(id));
	}
	
	public List<Map<String,String>> getLamps()
	{
		List<Map<String,String>> map = new ArrayList<Map<String,String>>();
		List<Lampione> lampList = lampManager.getLamps();
		for(Lampione lamp : lampList)
		{
			map.add(jsonBuilder.buildLampMap(lamp));
		}
		return map;
	}
	
	public List<JsonObject> getLampsInArea(int idArea)
	{
		return lampManager.getLampsInArea(idArea);
	}
	
	public boolean addLamp(int idArea, double latitudine, double longitudine, String tipo, int voltaggio)
	{
		return lampManager.addLamp(idArea, latitudine, longitudine, tipo, voltaggio);
	}
	
	public boolean deleteLamp(int id)
	{
		return lampManager.deleteLamp(id);
	}
	
	public JsonObject getSensor(int id)
	{
		return sensorManager.getSensor(id);
	}
	
	public List<JsonObject> getSensors()
	{
		return sensorManager.getSensors();
	}
	
	public List<JsonObject> getSensorsInArea(int idArea)
	{
		return sensorManager.getSensors();
	}
	
	@Transactional
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int raggio)
	{
		return sensorManager.addSensor(idArea, latitudine, longitudine, tipo, raggio);
	}
	
	@Transactional
	public boolean deleteSensor(int id)
	{
		return sensorManager.deleteSensor(id);
	}
	
	public String getArea(int id)
	{
		return areaManager.getArea(id);
	}
	
	public boolean deleteArea(int id)
	{
		return areaManager.deleteArea(id);
	}
	
	public boolean saveArea(String nome, boolean autoMode, int lvlInf, int lvlSup)
	{
		return areaManager.saveArea(nome, autoMode, lvlInf, lvlSup);
	}
	
	public boolean moveMeasurer(int newAreaId, int misId, double newX, double newY)
	{
		return areaManager.moveMeasurer(newAreaId, misId, newX, newY);
	}
}
