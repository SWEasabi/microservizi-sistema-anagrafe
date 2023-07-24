package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.LampRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.repositories.SensorRepository;
import com.SWEasabi.gestione.services.JsonBuilderService;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;

public class LampManager {
	
	@Autowired
	private MisuratoreRepository measurerRepo;
	
	@Autowired
	private LampRepository lampRepo;
	
	@Autowired
	private JsonBuilderService jsonBuilder;
	
	public Lampione getLamp(int id)
	{
		Lampione lamp = lampRepo.findById(id);
		
		return lamp;
	}
	
	public List<Lampione> getLamps()
	{
	    List<Lampione> lampList = lampRepo.findAll();
	    return lampList;
	}
	
	public List<Lampione> getLampsInArea(int idArea)
	{
		List<Misuratore> misList = measurerRepo.findByTipoAndIdarea("lampione",(long)idArea);
	    List<Lampione> lampList = new ArrayList<Lampione>();
	    for(Misuratore m : misList)
	    {
	    	lampList.add(lampRepo.findById((long)m.getId()));
	    }
	    return lampList;
	}
	
	@Transactional
	public boolean addLamp(int idArea, double latitudine, double longitudine, String tipo, int voltaggio)
	{
		Misuratore mis = new Misuratore((long)idArea,tipo,latitudine,longitudine);
		Lampione lamp = new Lampione(voltaggio);
		mis.setLampione(lamp);
		lamp.setMisuratore(mis);
		Misuratore resMis = measurerRepo.save(mis);
		Lampione resLamp = lampRepo.save(lamp);
		return (resMis == null && resLamp == null) ? false : true;
	}
	
	@Transactional
	public boolean deleteLamp(int id)
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
