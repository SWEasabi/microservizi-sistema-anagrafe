package com.SWEasabi.gestione.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SensoreTest {

    Misuratore misuratore;
    Sensore sensore;
    Sensore sensore100;

    @Before
    public void setUp() throws Exception {
        misuratore = new Misuratore();

        sensore = new Sensore();
        sensore100 = new Sensore(100);
        sensore.setMisuratore(misuratore);
    }

    @Test
    public void testGetMisuratore() {
        assertEquals(misuratore, sensore.getMisuratore());
    }

    @Test
    public void testSetMisuratore() {
        Misuratore misuratore1 = new Misuratore();
        misuratore1.setId(1);

        sensore.setMisuratore(misuratore1);
        assertEquals(misuratore1, sensore.getMisuratore());
        sensore.setMisuratore(misuratore);
        assertEquals(misuratore, sensore.getMisuratore());
    }

    @Test
    public void testGetId() {
        assertEquals(0, sensore.getId());
    }

    @Test
    public void testSetId() {
        sensore.setId(1);
        assertEquals(1, sensore.getId());
        sensore.setId(0);
        assertEquals(0, sensore.getId());
    }

    @Test
    public void testGetRaggio() {
        assertEquals(100, sensore100.getRaggio());
    }

    @Test
    public void testSetRaggio() {
        sensore100.setRaggio(0);
        assertEquals(0, sensore100.getRaggio());
        sensore100.setRaggio(100);
        assertEquals(100, sensore100.getRaggio());
    }
    
    @Test
    public void testNullObj() {
        Object obj = null;
        assertFalse(sensore.equals(obj));
    }

    @Test
    public void testObjClass() {
        Object obj = new Misuratore();
        assertFalse(sensore.equals(obj));
    }

    @Test
    public void testNotEquals() {
        assertFalse(sensore.equals(sensore100));
    }

    @Test
    public void testEquals() {
        Sensore sensore0 = new Sensore();
        sensore0.setMisuratore(misuratore);

        assertTrue(sensore.equals(sensore0));
    }
}