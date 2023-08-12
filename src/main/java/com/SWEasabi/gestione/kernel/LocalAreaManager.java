package com.SWEasabi.gestione.kernel;

import java.util.ArrayList;
import java.util.List;

import com.SWEasabi.gestione.entities.Area;

public class LocalAreaManager implements AreaManager {

	@Override
	public Area getArea(int id) {
		if(id>0) {
			Area area = new Area();
			area.setId(id);
			return area;
		}
		return null;
	}

	@Override
	public List<Area> getAreas() {
		List<Area> list = new ArrayList<Area>();
		for(int i=1;i<11;++i) {
			list.add(new Area());
			list.get(i).setId(i);
		}
		return list;
	}

	@Override
	public boolean deleteArea(int id) {
		if(id>0) return true;
		return false;
	}

	@Override
	public boolean saveArea(Area area) {
		if(area != null) return true;
		return false;
	}

	@Override
	public boolean moveMeasurer(int newAreaId, int misId, double newX, double newY) {
		if(newAreaId>0&&misId>0) return true;
		return false;
	}

}
