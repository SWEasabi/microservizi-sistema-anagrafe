package com.SWEasabi.gestione.kernel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.SWEasabi.gestione.entities.Lampione;
import com.SWEasabi.gestione.entities.Misuratore;
import java.util.List;


public class LocalLampManagerTest {

    LampManager lampManager;

    @BeforeEach
    public void setUp() {
        lampManager = new LocalLampManager();
    }

    @Test
    public void testGetLamp() {
        Lampione result = lampManager.getLamp(5);
        assertNotNull(result);
        assertNotNull(result.getMisuratore());

        result = lampManager.getLamp(-1);
        assertNull(result);
    }

    @Test
    public void testGetLamps() {
        List<Lampione> lamps = lampManager.getLamps();
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
        List<Lampione> lamps = lampManager.getLampsInArea(idArea);
        assertNotNull(lamps);
        assertEquals(10, lamps.size());

        for (Lampione lamp : lamps) {
            assertNotNull(lamp.getMisuratore());
            assertEquals(idArea, lamp.getMisuratore().getArea().getId());
        }
    }

    @Test
    public void testAddLamp() {
        assertTrue(lampManager.addLamp(1, 10.0, 10.0, "", 100));
        assertFalse(lampManager.addLamp(0, 10.0, 10.0, "", 100));
        assertFalse(lampManager.addLamp(-1, 10.0, 10.0, "", 100));
    }

    @Test
    public void testDeleteLamp() {
        assertTrue(lampManager.deleteLamp(1));
        assertFalse(lampManager.deleteLamp(0));
        assertFalse(lampManager.deleteLamp(-1));
    }
}