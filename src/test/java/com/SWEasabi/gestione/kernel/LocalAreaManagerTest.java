package com.SWEasabi.gestione.kernel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.SWEasabi.gestione.entities.Area;
import java.util.List;

public class LocalAreaManagerTest {

    LocalAreaManager areaManager;

    @BeforeEach
    public void setUp() {
        areaManager = new LocalAreaManager();
    }

    @Test
    public void testGetArea() {
        Area result = areaManager.getArea(5);
        assertNotNull(result);
        assertEquals(5, result.getId());

        result = areaManager.getArea(-1);
        assertNull(result);
    }

    @Test
    public void testGetAreas() {
        List<Area> areas = areaManager.getAreas();
        assertNotNull(areas);
        assertEquals(10, areas.size());

        for (int i=0; i<10; i++) {
            assertEquals(i+1, areas.get(i).getId());
        }
    }

    @Test
    public void testDeleteArea() {
        assertTrue(areaManager.deleteArea(5));
        assertFalse(areaManager.deleteArea(0));
        assertFalse(areaManager.deleteArea(-1));
    }

    @Test
    public void testSaveArea() {
        Area area = new Area();
        assertTrue(areaManager.saveArea(area));
        assertFalse(areaManager.saveArea(null));
    }

    @Test
    public void testMoveMeasurer() {
        assertTrue(areaManager.moveMeasurer(1, 1, 10.0, -10.0));
        assertFalse(areaManager.moveMeasurer(-1, 1, 10.0, 10.0));
        assertFalse(areaManager.moveMeasurer(1, -1, 10.0, 10.0));
    }
}
