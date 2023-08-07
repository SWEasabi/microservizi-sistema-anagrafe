package com.SWEasabi.gestione.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.kernel.AreaManager;
import com.SWEasabi.gestione.kernel.LampManager;
import com.SWEasabi.gestione.kernel.SensorManager;

import jakarta.transaction.Transactional;

public class CoreGestione {
	
	@Autowired
	private LampManager lampManager;
	
	@Autowired
	private SensorManager sensorManager;
	
	@Autowired
	private AreaManager areaManager;
	
	public Lampione getLamp(int id)
	{
		return lampManager.getLamp(id);
	}
	
	public List<Lampione> getLamps()
	{
		return lampManager.getLamps();
	}
	
	public List<Lampione> getLampsInArea(int idArea)
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
	
	public Sensore getSensor(int id)
	{
		return sensorManager.getSensor(id);
	}
	
	public List<Sensore> getSensors()
	{
		return sensorManager.getSensors();
	}
	
	public List<Sensore> getSensorsInArea(int idArea)
	{
		return sensorManager.getSensorsInArea(idArea);
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
	
	public Area getArea(int id)
	{
		return areaManager.getArea(id);
	}
	
	public List<Area> getAreas()
	{
		return areaManager.getAreas();
	}
	
	public boolean deleteArea(int id)
	{
		return areaManager.deleteArea(id);
	}
	
	public boolean saveArea(Area area)
	{
		return areaManager.saveArea(area);
	}
	
	public boolean moveMeasurer(int newAreaId, int misId, double newX, double newY)
	{
		return areaManager.moveMeasurer(newAreaId, misId, newX, newY);
	}
}
