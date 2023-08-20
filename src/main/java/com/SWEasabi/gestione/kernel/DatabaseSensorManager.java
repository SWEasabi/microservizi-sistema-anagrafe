package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.repositories.SensorRepository;

import jakarta.transaction.Transactional;

public class DatabaseSensorManager implements SensorManager {
	
	
	@Autowired
	private MisuratoreRepository measurerRepo;
	
	@Autowired
	private SensorRepository sensorRepo;
	
	@Autowired
    private AreaRepository areaRepo;

	public Sensore getSensor(int id)
	{
		Sensore sensor = sensorRepo.findById (id);
		if(sensor != null) {
			return sensor;
		}
		return new Sensore();
	}
	public List<Sensore> getSensors()
	{
	    return sensorRepo.findAll();
	}

	public List<Sensore> getSensorsInArea(int idArea)
	{
		List<Misuratore> misList = measurerRepo.findByTipoAndArea_id("sensore", idArea);
	    List<Sensore> sensorList = new ArrayList<> ();
	    for(Misuratore m : misList)
	    {
	    	sensorList.add(sensorRepo.findById(m.getId()));
	    }
	    
	    return sensorList;
	}

	/*private List<Sensore> removeSensorCircularRefs (List<Sensore> all) {
		return all.stream ()
			.peek (sensor -> {
				if (sensor.getMisuratore () != null) {
					sensor.getMisuratore ().setSensore (null);
				}
			})
			.toList ();
	}*/
	
	@Transactional
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int raggio)
	{
		Area area = areaRepo.findById(idArea);
		Misuratore mis = new Misuratore(tipo,latitudine,longitudine,area);
		Sensore sensor = new Sensore(raggio);
		Misuratore resMis = measurerRepo.save(mis);
		sensor.setMisuratore(resMis);
		Sensore resSensor = sensorRepo.save(sensor);
		return resMis != null || resSensor != null;
	}
	
	@Transactional
	public boolean deleteSensor(int id)
	{
		try {
			measurerRepo.deleteById(id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
