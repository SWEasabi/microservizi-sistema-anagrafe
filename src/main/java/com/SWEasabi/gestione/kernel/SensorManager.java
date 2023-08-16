package com.SWEasabi.gestione.kernel;

import java.util.List;

import com.SWEasabi.gestione.entities.Sensore;

public interface SensorManager {
	public Sensore getSensor(int id);
	public List<Sensore> getSensors();
	public List<Sensore> getSensorsInArea(int idArea);
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int voltaggio);
	public boolean deleteSensor(int id);
}
