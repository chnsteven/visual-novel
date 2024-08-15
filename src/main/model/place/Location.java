package model.place;

public class Location {
    private String locationName;
    private Coordinate coordinate;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    // MODIFIES: this, Coordinate
    // EFFECTS: assign Coordinate to Location
    public void assignCoordinate(Coordinate coordinate) {
        if (this.coordinate != coordinate) {
            removeFromCoordinate();
            this.coordinate = coordinate;
            coordinate.assignLocation(this);
        }
    }

    //MODIFIES: this, Coordinate
    //EFFECTS: if location is assigned to a coordinate, remove it, else do nothing
    public void removeFromCoordinate() {
        Coordinate c = getCoordinate();
        if (isAssignedToCoordinate()) {
            coordinate = null;
            c.removeLocation(this);
        }
    }

    public boolean isAssignedToCoordinate() {
        return getCoordinate() != null;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getCoordinateString() {
        return "(" + coordinate.getX0() + ", " + coordinate.getY0() + ")";
    }
}
