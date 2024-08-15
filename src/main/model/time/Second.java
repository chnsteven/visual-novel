package model.time;

import model.Time;
import model.place.Location;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Second implements Speed, Time {
    private double time;

    //MODIFIES: this
    //EFFECTS: calculate the time needed to travel from
    // Location 1 to Location 2
    @Override
    public void calculateTime(Location l1, Location l2, double speed) {
        time = java.lang.Math.sqrt((Math.pow(((l2.getCoordinate().getY0()) - l1.getCoordinate().getY0()), 2))
                + (Math.pow(((l2.getCoordinate().getX0()) - l1.getCoordinate().getX0()), 2))) / speed;
    }

    //EFFECTS: Starting from time, decrement by 1 second for each loop, print out the ith int during looping
    @Override
    public void printCountdown(double time, JLabel dialogContent) throws InterruptedException {
        for (int i = (int) time; i > 0; i--) {
            dialogContent.setText(Integer.toString(i));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public Double getSecond() {
        return time;
    }
}