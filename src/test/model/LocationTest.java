package model;

import model.place.Coordinate;
import model.place.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {
    private Location location;

    private Coordinate c0;
    private Coordinate c1;

    @BeforeEach
    public void setUp() {
        location = new Location("Hospital");
        addCoordinates();
    }

    @Test
    public void testConstructor() {
        assertEquals("Hospital", location.getLocationName());
    }

    @Test
    public void testAssignOneCoordinate() {
        assertFalse(location.isAssignedToCoordinate());
        location.assignCoordinate(c0);
        assertTrue(location.isAssignedToCoordinate());
        assertEquals(c0.getX0(), location.getCoordinate().getX0());
        assertEquals(c0.getY0(), location.getCoordinate().getY0());
        assertEquals(location, c0.getLocation());
    }

    @Test
    public void testAssignAnotherCoordinate() {
        assertFalse(location.isAssignedToCoordinate());
        location.assignCoordinate(c0);
        assertTrue(location.isAssignedToCoordinate());
        assertEquals(c0, location.getCoordinate());
        assertEquals(location, c0.getLocation());

        location.assignCoordinate(c1);
        assertEquals(c1, location.getCoordinate());
        assertEquals(location, c1.getLocation());
        assertNull(c0.getLocation());
    }

    @Test
    public void testRemoveFromCoordinate() {
        location.assignCoordinate(c0);

        location.removeFromCoordinate();
        assertFalse(location.isAssignedToCoordinate());
        assertNull(location.getCoordinate());
    }

    @Test
    public void testGetCoordinateString() {
        location.assignCoordinate(c0);
        location.getCoordinateString();
        assertEquals("(10, 10)", location.getCoordinateString());
    }

    private void addCoordinates() {
        c0 = new Coordinate(10, 10);
        c1 = new Coordinate(100, 100);
    }
}
