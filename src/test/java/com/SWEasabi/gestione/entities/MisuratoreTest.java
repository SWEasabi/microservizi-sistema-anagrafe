package com.SWEasabi.gestione.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MisuratoreTest {

    Misuratore misuratore;
    Sensore sensore;
    Misuratore misuratore_sensore;
    Lampione lampione;
    Misuratore misuratore_lampione;
    Area area;

    @Before
    public void setUp() throws Exception {
    	area = new Area();
        misuratore = new Misuratore();

        sensore = new Sensore();
        misuratore_sensore = new Misuratore( "Sensore", 0.0, 0.0, new Area());
        sensore.setMisuratore(misuratore_sensore);
        misuratore_sensore.setSensore(sensore);
        
        lampione = new Lampione();
        misuratore_lampione = new Misuratore("Lampione", 0.0, 0.0, new Area());
        lampione.setMisuratore(misuratore_lampione);
        misuratore_lampione.setLampione(lampione);

    }

    @Test
    public void testGetSensore() {
        assertEquals(sensore, misuratore_sensore.getSensore());
    }

    @Test
    public void testSetSensore() {
        Sensore sensore1 = new Sensore();
        sensore1.setMisuratore(misuratore_sensore);
        
        misuratore_sensore.setSensore(sensore1);
        assertEquals(sensore1, misuratore_sensore.getSensore());
        misuratore_sensore.setSensore(sensore);
        assertEquals(sensore, misuratore_sensore.getSensore());
    }

    @Test
    public void testGetLampione() {
        assertEquals(lampione, misuratore_lampione.getLampione());
    }

    @Test
    public void testSetLampione() {
        Lampione lampione1 = new Lampione();
        lampione1.setMisuratore(misuratore_lampione);

        misuratore_lampione.setLampione(lampione1);
        assertEquals(lampione1, misuratore_lampione.getLampione());
        misuratore_lampione.setLampione(lampione);
        assertEquals(lampione, misuratore_lampione.getLampione());
    }

    @Test
    public void testGetId() {
        assertEquals(0, misuratore.getId());
    }

    @Test
    public void testSetId() {
        misuratore.setId(1);
        assertEquals(1, misuratore.getId());
        misuratore.setId(0);
        assertEquals(0, misuratore.getId());
    }

    @Test
    public void testGetIdArea() {
    	misuratore.setArea(area);
        assertEquals(0, misuratore.getArea().getId());
    }

    @Test
    public void testSetIdArea() {
    	area.setId(1);
        misuratore.setArea(area);
        assertEquals(1, misuratore.getArea().getId());
        misuratore.getArea().setId(0);;
        assertEquals(0, misuratore.getArea().getId());
    }

    @Test
    public void testGetTipo() {
        assertEquals("Sensore", misuratore_sensore.getTipo());
        assertEquals("Lampione", misuratore_lampione.getTipo());
    }

    @Test
    public void testSetTipo() {
        misuratore_sensore.setTipo("Lampione");
        misuratore_lampione.setTipo("Sensore");
        assertEquals("Sensore", misuratore_lampione.getTipo());
        assertEquals("Lampione",  misuratore_sensore.getTipo());
        misuratore_sensore.setTipo("Sensore");
        misuratore_lampione.setTipo("Lampione");
        assertEquals("Sensore", misuratore_sensore.getTipo());
        assertEquals("Lampione", misuratore_lampione.getTipo());
    }

    @Test
    public void testGetLatitudine() {
        assertEquals(0.0, misuratore.getLatitudine(), 10^-8);
    }

    @Test
    public void testSetLatitudine() {
        misuratore.setLatitudine(0.00000001);
        assertEquals(0.00000001, misuratore.getLatitudine(), 10^-8);
        misuratore.setLatitudine(0.0);
        assertEquals(0.0, misuratore.getLatitudine(), 10^-8);
    }

    @Test
    public void testGetLongitudine() {
        assertEquals(0.0, misuratore.getLongitudine(), 10^-8);
    }

    @Test
    public void testSetLongitudine() {
        misuratore.setLongitudine(0.00000001);
        assertEquals(0.00000001, misuratore.getLongitudine(), 10^-8);
        misuratore.setLongitudine(0.0);
        assertEquals(0.0, misuratore.getLongitudine(), 10^-8);
    }

    @Test
    public void testNullObj() {
        Object obj = null;
        assertFalse(misuratore.equals(obj));
    }

    @Test
    public void testObjClass() {
        Object obj = new Sensore();
        assertFalse(misuratore.equals(obj));
    }

    @Test
    public void testNotEquals() {
        assertFalse(misuratore.equals(misuratore_sensore));
        assertFalse(misuratore.equals(misuratore_lampione));
    }

    @Test
    public void testEquals() {
        Misuratore misuratore1 = new Misuratore();

        assertEquals(misuratore, misuratore1);
    }
}

