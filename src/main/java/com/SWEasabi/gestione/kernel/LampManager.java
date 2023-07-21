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
	
	public JsonObject getLamp(int id)
	{
		Lampione lamp = lampRepo.findById((long)id);
		Misuratore misuratore = measurerRepo.findById(lamp.getIdMisuratore());
		return jsonBuilder.buildLampJson(lamp, misuratore);
	}
	
	public List<JsonObject> getLamps()
	{
		List<Misuratore> misList = new ArrayList<Misuratore>();
	    misList = measurerRepo.findByTipo("lampione");
	    List<Lampione> lampList = new ArrayList<Lampione>();
	    for(Misuratore m : misList)
	    {
	    	lampList.add(lampRepo.findByIdmisuratore((long)m.getId()));
	    }
	    
	    List<JsonObject> jsonList = new ArrayList<JsonObject>();
	    for(int i=0;i<lampList.size();i++)
	    {
	    	jsonList.add(jsonBuilder.buildLampJson(lampList.get(i), misList.get(i)));
	    }
	    return jsonList;
	}
	
	public List<JsonObject> getLampsInArea(int idArea)
	{
		List<Misuratore> misList = new ArrayList<Misuratore>();
	    misList = measurerRepo.findByTipoAndIdarea("lampione",(long)idArea);
	    List<Lampione> lampList = new ArrayList<Lampione>();
	    for(Misuratore m : misList)
	    {
	    	lampList.add(lampRepo.findByIdmisuratore((long)m.getId()));
	    }
	    
	    List<JsonObject> jsonList = new ArrayList<JsonObject>();
	    for(int i=0;i<lampList.size();i++)
	    {
	    	jsonList.add(jsonBuilder.buildLampJson(lampList.get(i), misList.get(i)));
	    }
	    return jsonList;
	}
	
	@Transactional
	public boolean addLamp(int idArea, double latitudine, double longitudine, String tipo, int voltaggio)
	{
		Misuratore mis = new Misuratore((long)idArea,tipo,latitudine,longitudine);
		Lampione lamp = new Lampione((long)12,voltaggio);
		Misuratore resMis = measurerRepo.save(mis);
		Lampione resLamp = lampRepo.save(lamp);
		return (resMis == null && resLamp == null) ? false : true;
	}
	
	@Transactional
	public boolean deleteLamp(int id)
	{
		Lampione lamp = lampRepo.findById((long)id);
		return (measurerRepo.deleteById(lamp.getIdMisuratore()) && lampRepo.deleteById(id));
	}
	
}
