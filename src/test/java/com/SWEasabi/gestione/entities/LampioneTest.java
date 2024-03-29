package com.SWEasabi.gestione.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LampioneTest {

    Misuratore misuratore;
    Lampione lampione;
    Lampione lampione100;

    @Before
    public void setUp() throws Exception {
        misuratore = new Misuratore();

        lampione = new Lampione();
        lampione100 = new Lampione(100);
        lampione.setMisuratore(misuratore);
    }

    @Test
    public void testGetMisuratore() {
        assertEquals(misuratore, lampione.getMisuratore());
    }

    @Test
    public void testSetMisuratore() {
        Misuratore misuratore1 = new Misuratore();
        misuratore1.setId(1);

        lampione.setMisuratore(misuratore1);
        assertEquals(misuratore1, lampione.getMisuratore());
        lampione.setMisuratore(misuratore);
        assertEquals(misuratore, lampione.getMisuratore());
    }

    @Test
    public void testGetId() {
        assertEquals(0, lampione.getId());
    }

    @Test
    public void testSetId() {
        lampione.setId(1);
        assertEquals(1, lampione.getId());
        lampione.setId(0);
        assertEquals(0, lampione.getId());
    }

    @Test
    public void testGetWattaggio() {
        assertEquals(100, lampione100.getWattaggio());
    }

    @Test
    public void testSetWattaggio() {
        lampione100.setWattaggio(0);
        assertEquals(0, lampione100.getWattaggio());
        lampione100.setWattaggio(100);
        assertEquals(100, lampione100.getWattaggio());
    }

    @Test
    public void testGetLuminosita() {
        assertEquals(0, lampione100.getLuminosita());
    }

    @Test
    public void testSetLuminosita() {
        lampione100.setLuminosita(100);
        assertEquals(100, lampione100.getLuminosita());
        lampione100.setLuminosita(0);
        assertEquals(0, lampione100.getLuminosita());
    }

    @Test
    public void testNullObj() {
        Object obj = null;
        assertFalse(lampione.equals(obj));
    }

    @Test
    public void testObjClass() {
        Object obj = new Misuratore();
        assertFalse(lampione.equals(obj));
    }

    @Test
    public void testNotEquals() {
        assertFalse(lampione.equals(lampione100));
    }

    @Test
    public void testEquals() {
        Lampione lampione0 = new Lampione();
        lampione0.setMisuratore(misuratore);

        assertTrue(lampione.equals(lampione0));
    }
}