package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.repositories.SensorRepository;

import jakarta.transaction.Transactional;

public class DatabaseSensorManager implements SensorManager {
	
	
	@Autowired
	private MisuratoreRepository measurerRepo;
	
	@Autowired
	private SensorRepository sensorRepo;

	public Sensore getSensor(int id)
	{
		Sensore sensor = sensorRepo.findById (id);
		if(sensor != null) {
	        List<Sensore> list = new ArrayList<Sensore>();
	        list.add(sensor);
	
	        list = removeSensorCircularRefs(list);
	        return list.get(0);
		}
		return new Sensore();
	}
	public List<Sensore> getSensors()
	{
	    return removeSensorCircularRefs(sensorRepo.findAll());
	}

	public List<Sensore> getSensorsInArea(int idArea)
	{
		List<Misuratore> misList = measurerRepo.findByTipoAndIdarea("sensore", idArea);
	    List<Sensore> sensorList = new ArrayList<> ();
	    for(Misuratore m : misList)
	    {
	    	sensorList.add(sensorRepo.findById(m.getId()));
	    }
	    
	    return removeSensorCircularRefs(sensorList);
	}

	private List<Sensore> removeSensorCircularRefs (List<Sensore> all) {
		return all.stream ()
			.peek (sensor -> {
				if (sensor.getMisuratore () != null) {
					sensor.getMisuratore ().setSensore (null);
				}
			})
			.toList ();
	}
	
	@Transactional
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int voltaggio)
	{
		Misuratore mis = new Misuratore(idArea,tipo,latitudine,longitudine);
		Sensore sensor = new Sensore(voltaggio);
		mis.setSensore(sensor);
		sensor.setMisuratore(mis);
		Misuratore resMis = measurerRepo.save(mis);
		Sensore ressensor = sensorRepo.save(sensor);
		return resMis != null || ressensor != null;
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
