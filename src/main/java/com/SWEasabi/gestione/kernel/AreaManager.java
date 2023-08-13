package com.SWEasabi.gestione.kernel;

import java.util.List;

import com.SWEasabi.gestione.entities.Area;

public interface AreaManager {
	public Area getArea(int id);
	public List<Area> getAreas();
	public boolean deleteArea(int id);
	public boolean saveArea(Area area);
	public boolean moveMeasurer(int newAreaId, int misId, double newX, double newY);
}
