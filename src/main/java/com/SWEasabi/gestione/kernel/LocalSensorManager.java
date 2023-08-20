package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.entities.Sensore;

public class LocalSensorManager implements SensorManager {

	@Override
	public Sensore getSensor(int id) {
		if(id>0) {
			Sensore sensore = new Sensore();
			Misuratore mis = new Misuratore();
			Area area = new Area();
			sensore.setMisuratore(mis);
			sensore.getMisuratore().setArea(area);
			return sensore;
		}
		return null;
	}

	@Override
	public List<Sensore> getSensors() {
		List<Sensore> list = new ArrayList<Sensore>();
		for(int i=0;i<10;++i) {
			list.add(new Sensore());
			Area area = new Area();
			Misuratore mis = new Misuratore();
			list.get(i).setMisuratore(mis);
			list.get(i).getMisuratore().setArea(area);
			list.get(i).setId(i+1);
		}
		return list;
	}

	@Override
	public List<Sensore> getSensorsInArea(int idArea) {
		List<Sensore> list = new ArrayList<Sensore>();
		for(int i=0;i<10;++i) {
			list.add(new Sensore());
			list.get(i).setMisuratore(new Misuratore());
			Area area = new Area();
			area.setId(idArea);
			list.get(i).getMisuratore().setArea(area);
			list.get(i).setId(i+1);
		}
		return list;
	}

	@Override
	public boolean addSensor(int idArea, double latitudine, double longitudine, String tipo, int voltaggio) {
		if(idArea>0) return true;
		return false;
	}

	@Override
	public boolean deleteSensor(int id) {
		if(id>0) return true;
		return false;
	}

}
