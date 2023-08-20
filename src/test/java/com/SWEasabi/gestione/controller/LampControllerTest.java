package com.SWEasabi.gestione.controller;

import com.SWEasabi.gestione.DTO.LampDTO;
import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.kernel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LampControllerTest {
    LampManager lampManager;
    SensorManager sensorManager;
    AreaManager areaManager;
    CoreGestione core;
    LampController lampController;

    @BeforeEach
    public void setUp() {
        lampManager = new LocalLampManager();
        sensorManager = new LocalSensorManager();
        areaManager = new LocalAreaManager();
        core = new CoreGestione(lampManager, sensorManager, areaManager);
        lampController = new LampController(core);
    }

    @Test
    public void testGetLamp() {
        LampDTO result = lampController.getLamp(5);
        assertNotNull(result);

        result = lampController.getLamp(-1);
        assertNull(result);
    }

    @Test
    public void testGetLamps() {
        List<LampDTO> lamps = lampController.getAllLamps();
        assertNotNull(lamps);
        assertEquals(10, lamps.size());

        for (int i=0; i<10; i++) {
            assertNotNull(lamps.get(i));
            assertEquals(i+1, lamps.get(i).id());
        }
    }

    @Test
    public void testGetLampsInArea() {
        int idArea = 2;
        List<LampDTO> lamps = lampController.getLampsInArea(idArea);
        assertNotNull(lamps);
        assertEquals(10, lamps.size());

        for (LampDTO lamp : lamps) {
            assertEquals(idArea, lamp.idArea());
        }
    }

    @Test
    public void testAddLamp() {
        LampController.LampInsertInput lampData1 = new LampController.LampInsertInput(1, 10.0, 10.0, "", 100);
        LampController.LampInsertInput lampData0 = new LampController.LampInsertInput(0, 10.0, 10.0, "", 100);
        LampController.LampInsertInput lampDataN = new LampController.LampInsertInput(-1, 10.0, 10.0, "", 100);

        assertTrue(lampController.addLamp(lampData1));
        assertFalse(lampController.addLamp(lampData0));
        assertFalse(lampController.addLamp(lampDataN));
    }

    @Test
    public void testDeleteLamp() {
        assertTrue(lampController.deleteLamp(1));
        assertFalse(lampController.deleteLamp(0));
        assertFalse(lampController.deleteLamp(-1));
    }

}