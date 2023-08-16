package com.SWEasabi.gestione.controller;

import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.entities.Area;
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

public class AreaControllerTest {
    LampManager lampManager;
    SensorManager sensorManager;
    AreaManager areaManager;
    CoreGestione core;
    AreaController areaController;

    @BeforeEach
    public void setUp() {
        lampManager = new LocalLampManager();
        sensorManager = new LocalSensorManager();
        areaManager = new LocalAreaManager();
        core = new CoreGestione(lampManager, sensorManager, areaManager);
        areaController = new AreaController(core);
    }

    @Test
    public void testGetArea() {
        Area result = areaController.getArea(5);
        assertNotNull(result);
        assertEquals(5, result.getId());

        result = areaController.getArea(-1);
        assertNull(result);
    }

    @Test
    public void testGetAreas() {
        List<Area> areas = areaController.getAreas();
        assertNotNull(areas);
        assertEquals(10, areas.size());

        for (int i=0; i<10; i++) {
            assertEquals(i+1, areas.get(i).getId());
        }
    }

    @Test
    public void testDeleteArea() {
        assertTrue(areaController.deleteArea(5));
        assertFalse(areaController.deleteArea(0));
        assertFalse(areaController.deleteArea(-1));
    }

    @Test
    public void testSaveArea() {
        assertTrue(areaController.saveArea("area"));
    }

    @Test
    public void testMoveMeasurer() {
        AreaController.MoveMeasurerInput moveMeasurerData11 = new AreaController.MoveMeasurerInput(1, 1, 10.0, -10.0);
        AreaController.MoveMeasurerInput moveMeasurerDataN1 = new AreaController.MoveMeasurerInput(-1, 1, 10.0, 10.0);
        AreaController.MoveMeasurerInput moveMeasurerData1N = new AreaController.MoveMeasurerInput(1, -1, 10.0, 10.0);

        assertTrue(areaController.moveMeasurer(moveMeasurerData11));
        assertFalse(areaController.moveMeasurer(moveMeasurerDataN1));
        assertFalse(areaController.moveMeasurer(moveMeasurerData1N));
    }
}