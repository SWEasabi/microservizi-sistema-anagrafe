package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.LampRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.repositories.SensorRepository;
import com.SWEasabi.gestione.services.JsonBuilderService;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;

public class SensorManager {
	
	
	@Autowired
	private MisuratoreRepository measurerRepo;
	
	@Autowired
	private SensorRepository sensorRepo;
	
	@Autowired
	private JsonBuilderService jsonBuilder;

	public JsonObject getSensor(int id)
	{
		Sensore sensor = sensorRepo.findById((long)id);
		Misuratore misuratore = measurerRepo.findById(sensor.getIdMisuratore());
		return jsonBuilder.buildSensorJson(sensor, misuratore);
	}
	
	public List<JsonObject> getSensors()
	{
		List<Misuratore> misList = new ArrayList<Misuratore>();
	    misList = measurerRepo.findByTipo("sensore");
	    List<Sensore> sensorList = new ArrayList<Sensore>();
	    for(Misuratore m : misList)
	    {
	    	sensorList.add(sensorRepo.findByIdmisuratore((long)m.getId()));
	    }
	    
	    List<JsonObject> jsonList = new ArrayList<JsonObject>();
	    for(int i=0;i<sensorList.size();i++)
	    {
	    	jsonList.add(jsonBuilder.buildSensorJson(sensorList.get(i), misList.get(i)));
	    }
	    return jsonList;
	}
	
	public List<JsonObject> getSensorsInArea(int idArea)
	{
		List<Misuratore> misList = new ArrayList<Misuratore>();
	    misList = measurerRepo.findByTipoAndIdarea("sensore",(long)idArea);
	    List<Sensore> sensorList = new ArrayList<Sensore>();
	    for(Misuratore m : misList)
	    {
	    	sensorList.add(sensorRepo.findByIdmisuratore((long)m.getId()));
	    }
	    
	    List<JsonObject> jsonList = new ArrayList<JsonObject>();
	    for(int i=0;i<sensorList.size();i++)
	    {
	    	jsonList.add(jsonBuilder.buildSensorJson(sensorList.get(i), misList.get(i)));
	    }
	    return jsonList;
	}
	
	@Transactional
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int raggio)
	{
		Misuratore mis = new Misuratore((long)idArea,tipo,latitudine,longitudine);
		Sensore sensor = new Sensore((long)12,raggio);
		Misuratore resMis = measurerRepo.save(mis);
		Sensore resSensor = sensorRepo.save(sensor);
		return (resMis == null && resSensor == null) ? false : true;
	}
	
	@Transactional
	public boolean deleteSensor(int id)
	{
		Sensore sensor = sensorRepo.findById((long)id);
		return (measurerRepo.deleteById(sensor.getIdMisuratore()) && sensorRepo.deleteById(id));
	}
}
