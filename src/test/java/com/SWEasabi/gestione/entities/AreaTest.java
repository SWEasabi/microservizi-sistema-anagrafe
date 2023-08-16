package com.SWEasabi.gestione.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaTest {

    Area area;
    Area area_auto;

    @Before
    public void setUp() throws Exception {
        area = new Area();
        area_auto = new Area("area_auto", true, 0, 100);
    }

    @Test
    public void testToString() {
        String expected1 = "Id = 0 Nome = test";
        String expected2 = "Id = 0 Nome = area_auto";

        assertEquals(expected1, area.toString());
        assertEquals(expected2, area_auto.toString());
    }

    @Test
    public void testCopyConstructor() {
        Area area_copy = new Area(area);
        assertEquals(area, area_copy);
    }

    @Test
    public void testGetId() {
        assertEquals(0, area.getId());
    }

    @Test
    public void testSetId() {
        area.setId(1);
        assertEquals(1, area.getId());
        area.setId(0);
        assertEquals(0, area.getId());
    }

    @Test
    public void testGetNome() {
        assertEquals("test", area.getNome());
    }

    @Test
    public void testSetNome() {
        area.setNome("area");
        assertEquals("area", area.getNome());
        area.setNome("test");
        assertEquals("test", area.getNome());
    }

    @Test
    public void testIsautomode() {
        assertEquals(false, area.isautomode());
        assertEquals(true, area_auto.isautomode());
    }

    @Test
    public void testSetautomode() {
        area.setautomode(true);
        assertEquals(true, area.isautomode());
        area.setautomode(false);
        assertEquals(false, area.isautomode());
    }

    @Test
    public void testGetlvlinf() {
        assertEquals(0, area_auto.getlvlinf());
    }

    @Test
    public void testSetlvlinf() {
        area_auto.setlvlinf(100);
        assertEquals(100, area_auto.getlvlinf());
        area_auto.setlvlinf(0);
        assertEquals(0, area_auto.getlvlinf());
    }

    @Test
    public void testGetlvlsup() {
        assertEquals(100, area_auto.getlvlsup());
    }

    @Test
    public void testSetlvlsup() {
        area_auto.setlvlsup(0);
        assertEquals(0, area_auto.getlvlsup());
        area_auto.setlvlsup(100);
        assertEquals(100, area_auto.getlvlsup());
    }

    @Test
    public void testNullObj() {
        Object obj = null;
        assertFalse(area.equals(obj));
    }

    @Test
    public void testObjClass() {
        Object obj = new Misuratore();
        assertFalse(area.equals(obj));
    }

    @Test
    public void testNotEquals() {
        assertFalse(area.equals(area_auto));
    }

    @Test
    public void testEquals() {
        Area area1 = new Area();

        assertTrue(area.equals(area1));
    }
}