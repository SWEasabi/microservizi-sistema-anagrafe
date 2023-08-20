package com.SWEasabi.gestione.kernel;
import static org.junit.jupiter.api.Assertions.*;
import com.SWEasabi.gestione.entities.Sensore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LocalSensorManagerTest {

    LocalSensorManager sensorManager;

    @BeforeEach
    public void setUp() {
        sensorManager = new LocalSensorManager();
    }

    @Test
    public void testGetSensor() {
        Sensore sensore = sensorManager.getSensor(1);
        assertNotNull(sensore);
        assertNotNull(sensore.getMisuratore());

        sensore = sensorManager.getSensor(-1);
        assertNull(sensore);
    }

    @Test
    public void testGetSensors() {
        List<Sensore> sensors = sensorManager.getSensors();
        assertEquals(10, sensors.size());

        for (int i=0; i<10; i++) {
            assertNotNull(sensors.get(i).getMisuratore());
            assertEquals(i+1, sensors.get(i).getId());
        }
    }

    @Test
    public void testGetSensorsInArea() {
        int idArea = 1;
        List<Sensore> sensors = sensorManager.getSensorsInArea(idArea);
        assertNotNull(sensors);
        assertEquals(10, sensors.size());

        for (Sensore sensore : sensors) {
            assertNotNull(sensore.getMisuratore());
            assertEquals(idArea, sensore.getMisuratore().getArea().getId());
        }
    }

    @Test
    public void testAddSensor() {
        assertTrue(sensorManager.addSensor(1, 10.0, 10.0, "", 100));
        assertFalse(sensorManager.addSensor(0, 10.0, 10.0, "", 100));
        assertFalse(sensorManager.addSensor(-1, 10.0, 10.0, "", 100));
    }

    @Test
    public void testDeleteSensor() {
        assertTrue(sensorManager.deleteSensor(1));
        assertFalse(sensorManager.deleteSensor(0));
        assertFalse(sensorManager.deleteSensor(-1));
    }
}