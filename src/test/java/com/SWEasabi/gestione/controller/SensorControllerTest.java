package com.SWEasabi.gestione.controller;

import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Sensore;
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

public class SensorControllerTest {
    LampManager lampManager;
    SensorManager sensorManager;
    AreaManager areaManager;
    CoreGestione core;
    SensorController sensorController;

    @BeforeEach
    public void setUp() {
        lampManager = new LocalLampManager();
        sensorManager = new LocalSensorManager();
        areaManager = new LocalAreaManager();
        core = new CoreGestione(lampManager, sensorManager, areaManager);
        sensorController = new SensorController(core);
    }

    @Test
    public void testGetSensor() {
        Sensore sensore = sensorController.getsensor(1);
        assertNotNull(sensore);
        assertNotNull(sensore.getMisuratore());

        sensore = sensorController.getsensor(-1);
        assertNull(sensore);
    }

    @Test
    public void testGetSensors() {
        List<Sensore> sensors = sensorController.getAllsensors();
        assertEquals(10, sensors.size());

        for (int i=0; i<10; i++) {
            assertNotNull(sensors.get(i).getMisuratore());
            assertEquals(i+1, sensors.get(i).getId());
        }
    }

    @Test
    public void testGetSensorsInArea() {
        int idArea = 1;
        List<Sensore> sensors = sensorController.getsensorsInArea(idArea);
        assertNotNull(sensors);
        assertEquals(10, sensors.size());

        for (Sensore sensore : sensors) {
            assertNotNull(sensore.getMisuratore());
            assertEquals(idArea, sensore.getMisuratore().getIdArea());
        }
    }

    @Test
    public void testAddSensor() {
        //TODO: Equivalente di testAddLamp se viene aggiunto il record su SensorController
    }

    @Test
    public void testDeleteSensor() {
        assertTrue(sensorController.deletesensor(1));
        assertFalse(sensorController.deletesensor(0));
        assertFalse(sensorController.deletesensor(-1));
    }
}