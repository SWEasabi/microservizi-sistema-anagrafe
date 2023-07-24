package com.SWEasabi.gestione.kernel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import com.SWEasabi.gestione.services.JsonBuilderService;

public class AreaManager {
	
	@Autowired
	private AreaRepository areaRepo;
	
	@Autowired
	private MisuratoreRepository measurerRepo;
	
	@Autowired
	private JsonBuilderService jsonBuilder;

	public Area getArea(int id)
	{
		return areaRepo.findById((long) id);
	}
	
	public List<Area> getAreas() {
		return areaRepo.findAll();
	}
	
	public boolean deleteArea(int id)
	{
		try {
			areaRepo.deleteById((long)id);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean saveArea(String nome, boolean autoMode, int lvlInf, int lvlSup)
	{
		return areaRepo.save(new Area(nome,autoMode,lvlInf,lvlSup)) == null ? false : true;
	}
	
	public boolean moveMeasurer(int newAreaId, int misId, double newX, double newY)
	{
		Misuratore measurer = measurerRepo.findById((long)misId);
		measurer.setIdArea(newAreaId);
		measurer.setLongitudine(newX);
		measurer.setLatitudine(newY);
		return (measurerRepo.save(measurer)) == null ? false : true;
	}
}
