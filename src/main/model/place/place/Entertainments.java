package model.place.place;

public class Entertainments extends Places {

    public Entertainments() {
        super();
    }

    //REQUIRES: list.size() == 3;
    //MODIFIES: List<Location>;
    //EFFECTS: sets the location name of each element in the list to the given String;
    // Given String is related to category Entertainments;
    @Override
    public void setAndPrintPlaces() {
        setLocations("Casino", "Amusement Park", "Karaoke");
        super.printPlaces();
    }
}
