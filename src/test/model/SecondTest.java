package model;

import model.place.Coordinate;
import model.place.Location;
import model.time.Speed;
import model.time.Second;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SecondTest {
    private Second t0;
    private Location l1;
    private Location l2;

    @BeforeEach
    public void setUp() {
        addLocations();
        t0 = new Second();
    }

    @Test
    public void testCalculateTime() {
        t0.calculateTime(l1, l2, Speed.WALK_SPEED);
        assertEquals(70.71067811865476,t0.getSecond());
        t0.calculateTime(l1, l2, Speed.TRANSPORTATION_SPEED);
        assertEquals(17.67766952966369, t0.getSecond());
        t0.calculateTime(l1, l2, Speed.STATIONARY);
        assertEquals(Double.POSITIVE_INFINITY, t0.getSecond());
    }

    @Test
    public void testPrintCountdown() {
        try {
            t0.printCountdown(1, new JLabel());
        } catch(InterruptedException e) {
            fail("No exception should be thrown!");
        }
    }

    private void addLocations() {
        l1 = new Location("A");
        l1.assignCoordinate(new Coordinate(100, 100));
        l2 = new Location("B");
        l2.assignCoordinate(new Coordinate(200, 200));
    }
}
