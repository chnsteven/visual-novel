package model.place;

public class Coordinate {
    private int x0;
    private int y0;
    private Location location;

    //EFFECTS: sets the coordinate to (x0, y0)
    public Coordinate(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    //REQUIRES: Coordinate can ONLY have ONE DISTINCT Location
    //MODIFIES: this, Location
    //EFFECTS: if this.Coordinate is not assign to any location, assign it the given location, else do nothing
    public void assignLocation(Location location) {
        if (this.location == null) {
            this.location = location;
            location.assignCoordinate(this);
        }
    }

    public Location getLocation() {
        return location;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    //MODIFIES: Location
    //EFFECTS: remove the Location that was previously assign to this.Coordinate
    public void removeLocation(Location location) {
        this.location = null;
        location.removeFromCoordinate();
    }
}
