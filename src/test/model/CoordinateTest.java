package model;

import model.place.Coordinate;
import model.place.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    private Location location;
    private Coordinate coordinate;

    @BeforeEach
    public void setUp() {
        location = new Location("Hospital");
        coordinate = new Coordinate(0, 0);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, coordinate.getX0());
        assertEquals(0, coordinate.getY0());
    }

    @Test
    public void testAssignOneLocation() {
        assertFalse(location.isAssignedToCoordinate());
        coordinate.assignLocation(location);
        assertTrue(location.isAssignedToCoordinate());
        assertEquals(0, coordinate.getX0());
        assertEquals(0, coordinate.getY0());
        assertEquals(location, coordinate.getLocation());
    }

    @Test
    public void testAssignDuplicateLocation() {
        assertFalse(location.isAssignedToCoordinate());
        coordinate.assignLocation(location);
        assertTrue(location.isAssignedToCoordinate());
        assertEquals(0, coordinate.getX0());
        assertEquals(0, coordinate.getY0());

        Location location1 = new Location("Park");
        coordinate.assignLocation(location1);
        assertFalse(location1.isAssignedToCoordinate());
    }

    @Test
    public void testRemoveLocation() {
        coordinate.assignLocation(location);
        coordinate.removeLocation(location);
        assertNull(coordinate.getLocation());
    }

    @Test
    public void testAssignAnotherLocation() {
        coordinate.assignLocation(location);
        coordinate.removeLocation(location);
        assertNull(coordinate.getLocation());

        Location location1 = new Location("Park");
        coordinate.assignLocation(location1);
        assertTrue(location1.isAssignedToCoordinate());
        assertEquals(0, coordinate.getX0());
        assertEquals(0, coordinate.getY0());
        assertEquals(location1, coordinate.getLocation());
    }
}
