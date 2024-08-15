package model;

import ui.Account;

import javax.swing.*;

public class Message {

    //EFFECTS: print out all necessary information of the user
    public static void restoreInfoMsg(Account acc) {
        JOptionPane.showMessageDialog(null,
                "Name: " + acc.getName() + "\n"
                        + "Gender: " + acc.getGender() + "\n"
                        + "Age: " + acc.getAge() + "\n");
    }

    //EFFECTS: print out exit message
    public static void quitMsg() {
        System.out.println("\bGoodbye~");
        System.out.println("\bAll user data are stored. Click Continue to load next time!");
    }

    //EFFECTS: print out warning message
    public static void warningMsg() {
        System.out.println("\bUse 1 / 2 / 3 to answer the following multiple choice.");
    }

    //EFFECTS: print out invalid input message
    public static void invalidInputMsg() {
        System.out.println("\bInvalid input Try Again");
    }

    //EFFECTS: print out game over message
    public static void gameOver() {
        JOptionPane.showMessageDialog(null, "GAME OVER");
    }

    //EFFECTS: print out win message
    public static void win() {
        JOptionPane.showMessageDialog(null, "CONGRATULATION");
    }
}
