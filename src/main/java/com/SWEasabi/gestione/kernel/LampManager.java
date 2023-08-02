package com.SWEasabi.gestione.kernel;

import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import com.SWEasabi.gestione.repositories.LampRepository;
import com.SWEasabi.gestione.repositories.MisuratoreRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LampManager {

    @Autowired
    private MisuratoreRepository measurerRepo;

    @Autowired
    private LampRepository lampRepo;

    public Lampione getLamp (int id) {
        Lampione lamp = lampRepo.findById (id);
        if(lamp != null) {
	        List<Lampione> list = new ArrayList<Lampione>();
	        list.add(lamp);
	
	        list = removeLampCircularRefs(list);
	        return list.get(0);
        }
        return new Lampione();
    }

    public List<Lampione> getLamps () {
        return removeLampCircularRefs(lampRepo.findAll ());
    }

    public List<Lampione> getLampsInArea (int idArea) {
        List<Misuratore> misList = measurerRepo.findByTipoAndIdarea ("lampione", (long) idArea);
        List<Lampione> lampList = new ArrayList<Lampione> ();
        for (Misuratore m : misList) {
            lampList.add (lampRepo.findById ((long) m.getId ()));
        }
        return removeLampCircularRefs(lampList);
    }

    private List<Lampione> removeLampCircularRefs (List<Lampione> all) {
	        return all.stream ()
	            .peek (sensor -> {
	                if (sensor.getMisuratore () != null) {
	                    sensor.getMisuratore ().setLampione (null);
	                }
	            })
	            .toList ();
    }
    @Transactional
    public boolean addLamp (int idArea, double latitudine, double longitudine, String tipo, int voltaggio) {
        Misuratore mis = new Misuratore (idArea, tipo, latitudine, longitudine);
        Lampione lamp = new Lampione (voltaggio);
        mis.setLampione (lamp);
        lamp.setMisuratore (mis);
        Misuratore resMis = measurerRepo.save (mis);
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
