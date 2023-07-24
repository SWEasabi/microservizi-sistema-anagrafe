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

	public Sensore getSensor(int id)
	{
		Sensore sensore = sensorRepo.findById((long)id);
		return sensore;
	}
	public List<Sensore> getSensors()
	{
	    List<Sensore> sensorList = sensorRepo.findAll();
	    
	    return sensorList;
	}
	
	public List<Sensore> getSensorsInArea(int idArea)
	{
		List<Misuratore> misList = measurerRepo.findByTipoAndIdarea("sensore",(long)idArea);
	    List<Sensore> sensorList = new ArrayList<Sensore>();
	    for(Misuratore m : misList)
	    {
	    	sensorList.add(sensorRepo.findById((long)m.getId()));
	    }
	    
	    return sensorList;
	}
	
	@Transactional
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int voltaggio)
	{
		Misuratore mis = new Misuratore((long)idArea,tipo,latitudine,longitudine);
		Sensore sensor = new Sensore(voltaggio);
		mis.setSensore(sensor);
		sensor.setMisuratore(mis);
		Misuratore resMis = measurerRepo.save(mis);
		Sensore ressensor = sensorRepo.save(sensor);
		return (resMis == null && ressensor == null) ? false : true;
	}
	
	@Transactional
	public boolean deleteSensor(int id)
	{
		try {
			measurerRepo.deleteById((long)id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
