package com.SWEasabi.gestione.kernel;

import java.util.List;

import com.SWEasabi.gestione.entities.Lampione;

public interface LampManager {
	public Lampione getLamp (int id);
	public List<Lampione> getLamps();
	public List<Lampione> getLampsInArea (int idArea);
	public boolean addLamp (int idArea, double latitudine, double longitudine, String tipo, int voltaggio);
	public boolean deleteLamp (int id);
}
