package model.place.place;

public class Schools extends Places {

    public Schools() {
        super();
    }

    //REQUIRES: list.size() == 3;
    //MODIFIES: List<Location>;
    //EFFECTS: sets the location name of each element in the list to the given String;
    // Given String is related to category Schools;
    @Override
    public void setAndPrintPlaces() {
        setLocations("Playground", "Classroom", "Cafeteria");
        super.printPlaces();
    }
}
