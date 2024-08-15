package model.place.place;

import model.place.Coordinate;
import model.place.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Places {
    protected List<Location> locations;
    private Location l1;
    private Location l2;
    private Location l3;


    public Places() {
        locations = new ArrayList<>();
        setAndPrintPlaces();
    }

    //MODIFIES: List<Location>
    //EFFECTS: assign a String to each element in the list, where the String represents the name of the location;
    // After the assignment, print out each element in the list and their corresponding coordinates;
    public abstract void setAndPrintPlaces();

    protected void setLocations(String name1, String name2, String name3) {
        setLocation(name1, name2, name3);
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
    }

    private void setLocation(String name1, String name2, String name3) {
        l1 = new Location(name1);
        l2 = new Location(name2);
        l3 = new Location(name3);
        l1.assignCoordinate(new Coordinate(randInt(), randInt()));
        l2.assignCoordinate(new Coordinate(randInt(), randInt()));
        l3.assignCoordinate(new Coordinate(randInt(), randInt()));
    }

    private int randInt() {
        Random r = new Random();
        return r.nextInt((100 - -100) + 1) + -100;
    }

    protected void printPlaces() {
        for (Location location : locations) {
            System.out.println("- " + location.getLocationName() + " " + location.getCoordinateString());
        }
    }
}
