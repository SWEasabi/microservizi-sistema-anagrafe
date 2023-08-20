package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;

public class LocalLampManager implements LampManager {

	@Override
	public Lampione getLamp(int id) {
		if(id>0) {
			Lampione lamp = new Lampione();
			Misuratore mis = new Misuratore();
			lamp.setMisuratore(mis);
			return lamp;
		}
		return null;
	}

	@Override
	public List<Lampione> getLamps() {
		List<Lampione> list = new ArrayList<Lampione>();
		for(int i=0;i<10;++i) {
			list.add(new Lampione());
			list.get(i).setMisuratore(new Misuratore());
			list.get(i).setId(i+1);
		}
		return list;
	}

	@Override
	public List<Lampione> getLampsInArea(int idArea) {
		List<Lampione> list = new ArrayList<Lampione>();
		for(int i=0;i<10;++i) {
			list.add(new Lampione());
			list.get(i).setMisuratore(new Misuratore());
			Area area = new Area();
			area.setId(idArea);
			list.get(i).getMisuratore().setArea(area);
			list.get(i).setId(i+1);
		}
		return list;
	}

	@Override
	public boolean addLamp(int idArea, double latitudine, double longitudine, String tipo, int voltaggio) {
		if(idArea>0) return true;
		return false;
	}

	@Override
	public boolean deleteLamp(int id) {
		if(id>0) return true;
		return false;
	}
	
}
