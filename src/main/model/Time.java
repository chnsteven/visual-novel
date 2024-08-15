package model;

import model.place.Coordinate;
import model.place.Location;

import javax.swing.*;

public interface Time {

    //REQUIRES: l1 != l2
    //EFFECTS: takes two Locations , speed of transportation, to calculate the time
    // needed to travel from one to another
    void calculateTime(Location l1, Location l2, double speed);

    //EFFECTS: Starting from time, decrement by 1 second for each loop, print out the ith int during looping
    void printCountdown(double time, JLabel dialogContent) throws InterruptedException;
}
