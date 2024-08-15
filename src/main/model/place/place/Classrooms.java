package model.place.place;

public class Classrooms extends Places {

    public Classrooms() {
        super();
    }

    //REQUIRES: list.size() == 3;
    //MODIFIES: List<Location>;
    //EFFECTS: sets the location name of each element in the list to the given String;
    // Given String is related to category Classrooms;
    @Override
    public void setAndPrintPlaces() {
        setLocations("Math Classroom", "CPSC Classroom", "English Classroom");
        super.printPlaces();
    }
}
