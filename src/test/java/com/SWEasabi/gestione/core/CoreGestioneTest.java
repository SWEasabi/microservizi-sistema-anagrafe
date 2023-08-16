package com.SWEasabi.gestione.core;

import com.SWEasabi.gestione.entities.Area;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Sensore;
import com.SWEasabi.gestione.kernel.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoreGestioneTest {
    LampManager lampManager;
    SensorManager sensorManager;
    AreaManager areaManager;
    CoreGestione core;

    @BeforeEach
    public void setUp() {
        lampManager = new LocalLampManager();
        sensorManager = new LocalSensorManager();
        areaManager = new LocalAreaManager();
        core = new CoreGestione(lampManager, sensorManager, areaManager);
    }

    @Test
    public void testGetLamp() {
        Lampione result = core.getLamp(5);
        assertNotNull(result);
        assertNotNull(result.getMisuratore());

        result = core.getLamp(-1);
        assertNull(result);
    }

    @Test
    public void testGetLamps() {
        List<Lampione> lamps = core.getLamps();
        assertNotNull(lamps);
        assertEquals(10, lamps.size());

        for (int i=0; i<10; i++) {
            assertNotNull(lamps.get(i).getMisuratore());
            assertEquals(i+1, lamps.get(i).getId());
        }
    }

    @Test
    public void testGetLampsInArea() {
        int idArea = 2;
        List<Lampione> lamps = core.getLampsInArea(idArea);
        assertNotNull(lamps);
        assertEquals(10, lamps.size());

        for (Lampione lamp : lamps) {
            assertNotNull(lamp.getMisuratore());
            assertEquals(idArea, lamp.getMisuratore().getIdArea());
        }
    }

    @Test
    public void testAddLamp() {
        assertTrue(core.addLamp(1, 10.0, 10.0, "", 100));
        assertFalse(core.addLamp(0, 10.0, 10.0, "", 100));
        assertFalse(core.addLamp(-1, 10.0, 10.0, "", 100));
    }

    @Test
    public void testDeleteLamp() {
        assertTrue(core.deleteLamp(1));
        assertFalse(core.deleteLamp(0));
        assertFalse(core.deleteLamp(-1));
    }

    @Test
    public void testGetSensor() {
        Sensore sensore = core.getSensor(1);
        assertNotNull(sensore);
        assertNotNull(sensore.getMisuratore());

        sensore = core.getSensor(-1);
        assertNull(sensore);
    }

    @Test
    public void testGetSensors() {
        List<Sensore> sensors = core.getSensors();
        assertEquals(10, sensors.size());

        for (int i=0; i<10; i++) {
            assertNotNull(sensors.get(i).getMisuratore());
            assertEquals(i+1, sensors.get(i).getId());
        }
    }

    @Test
    public void testGetSensorsInArea() {
        int idArea = 1;
        List<Sensore> sensors = core.getSensorsInArea(idArea);
        assertNotNull(sensors);
        assertEquals(10, sensors.size());

        for (Sensore sensore : sensors) {
            assertNotNull(sensore.getMisuratore());
            assertEquals(idArea, sensore.getMisuratore().getIdArea());
        }
    }

    @Test
    public void testAddSensor() {
        assertTrue(core.addSensor(1, 10.0, 10.0, "", 100));
        assertFalse(core.addSensor(0, 10.0, 10.0, "", 100));
        assertFalse(core.addSensor(-1, 10.0, 10.0, "", 100));
    }

    @Test
    public void testDeleteSensor() {
        assertTrue(core.deleteSensor(1));
        assertFalse(core.deleteSensor(0));
        assertFalse(core.deleteSensor(-1));
    }

    @Test
    public void testGetArea() {
        Area result = core.getArea(5);
        assertNotNull(result);
        assertEquals(5, result.getId());

        result = core.getArea(-1);
        assertNull(result);
    }

    @Test
    public void testGetAreas() {
        List<Area> areas = core.getAreas();
        assertNotNull(areas);
        assertEquals(10, areas.size());

        for (int i=0; i<10; i++) {
            assertEquals(i+1, areas.get(i).getId());
        }
    }

    @Test
    public void testDeleteArea() {
        assertTrue(core.deleteArea(5));
        assertFalse(core.deleteArea(0));
        assertFalse(core.deleteArea(-1));
    }

    @Test
    public void testSaveArea() {
        Area area = new Area();
        assertTrue(core.saveArea(area));
        assertFalse(core.saveArea(null));
    }

    @Test
    public void testMoveMeasurer() {
        assertTrue(core.moveMeasurer(1, 1, 10.0, -10.0));
        assertFalse(core.moveMeasurer(-1, 1, 10.0, 10.0));
        assertFalse(core.moveMeasurer(1, -1, 10.0, 10.0));
    }

}