package com.SWEasabi.gestione.kernel;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.repositories.AreaRepository;
import com.SWEasabi.gestione.repositories.LampRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseLampManager implements LampManager {

    @Autowired
    private MisuratoreRepository measurerRepo;

    @Autowired
    private LampRepository lampRepo;
    
    @Autowired
    private AreaRepository areaRepo;

    public Lampione getLamp (int id) {
        Lampione lamp = lampRepo.findById (id);
        if(lamp != null) {
        	return lamp;
        }
        return new Lampione();
    }

    public List<Lampione> getLamps () {
        return lampRepo.findAll ();
    }

    public List<Lampione> getLampsInArea (int idArea) {
        List<Misuratore> misList = measurerRepo.findByTipoAndArea_id ("lampione", (long) idArea);
        List<Lampione> lampList = new ArrayList<Lampione> ();
        for (Misuratore m : misList) {
            lampList.add (lampRepo.findById ((long) m.getId ()));
        }
        return lampList;
    }

    /*private List<Lampione> removeLampCircularRefs (List<Lampione> all) {
	        return all.stream ()
	            .peek (sensor -> {
	                if (sensor.getMisuratore () != null) {
	                    sensor.getMisuratore ().setLampione (null);
	                }
	            })
	            .toList ();
    }*/
    @Transactional
    public boolean addLamp (int idArea, double latitudine, double longitudine, String tipo, int voltaggio) {
        Area area = areaRepo.findById(idArea);
    	Misuratore mis = new Misuratore (tipo, latitudine, longitudine,area);
        Lampione lamp = new Lampione (voltaggio);
        Misuratore resMis = measurerRepo.save (mis);
        lamp.setMisuratore (resMis);
        Lampione resLamp = lampRepo.save (lamp);
        return resMis != null || resLamp != null;
    }

    @Transactional
    public boolean deleteLamp (int id) {
        try {
            measurerRepo.deleteById ((long) id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
