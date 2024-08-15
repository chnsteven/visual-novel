package ui;


import ui.exception.NonPositiveIntException;
import ui.exception.GenderException;
import ui.exception.StringException;

import javax.swing.*;


public class Account {
    private static final int legalAgeOfFlight = 16;

    private String accName;
    private String accGender;
    private String accAge;
    private Boolean activated;

    public Account() {
        activated = true;
    }

    //MODIFIES: this
    //EFFECTS: if not all info is stored, set the missing info,
    // in case of exception, handle each by prompting out an error message,
    // then resets the corresponding field to null
    public void setUserInfo() {
        while (missingInfo() && activated) {
            try {
                setMissingInfo();
            } catch (StringException e) {
                errorPrompt();
                accName = null;
            } catch (GenderException e) {
                errorPrompt();
                accGender = null;
            } catch (Exception e) {
                errorPrompt();
                accAge = null;
            }
        }

    }

    private void setMissingInfo() throws Exception {
        while (missingInfo() && activated) {
            if (accName == null) {
                setName();
            }
            if (accGender == null) {
                setGender();
            }
            if (accAge == null) {
                setAge();
            }
        }
    }

    private void errorPrompt() {
        JOptionPane.showMessageDialog(null,
                "UNEXPECTED ERROR",
                "", JOptionPane.ERROR_MESSAGE);
    }

    private boolean missingInfo() {
        return accName == null || accGender == null || accAge == null;
    }

    //MODIFIES: accName
    //EFFECTS: accName is set to user input
    private void setName() throws StringException {
        accName = JOptionPane.showInputDialog(null, "What's your name?");
        if (accName == null) {
            activated = false;
        }
        if (isInteger(accName) || accName.equals("")) {
            throw new StringException();
        }

    }

    //MODIFIES: this
    //EFFECTS: this.name = name
    public void setName(String s) {
        accName = s;
    }

    //EFFECTS: return true if param is a String or true otherwise
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    private void setGender() throws GenderException {
        accGender = JOptionPane.showInputDialog(null, "Are you female or male?");
        if (accGender.equals("")) {
            activated = false;
        }
        if (!accGender.equals("male") && !accGender.equals("female")) {
            throw new GenderException();
        }

    }

    //MODIFIES: this
    //EFFECTS: this.gender = gender
    public void setGender(String gender) {
        accGender = gender;
    }

    private void setAge() throws Exception {
        accAge = JOptionPane.showInputDialog(null, "How old are you?");
        if (accAge.equals("")) {
            activated = false;
        }
        if (!isInteger(accAge)) {
            throw new Exception();
        }
        if (Integer.parseInt(accAge) < 0) {
            throw new NonPositiveIntException();
        }

    }

    //MODIFIES: this
    //EFFECTS: this.age = age
    public void setAge(String age) {
        accAge = age;
    }

    //EFFECTS: return the name
    public String getName() {
        return accName;
    }

    //EFFECTS: return the gender
    public String getGender() {
        return accGender;
    }

    //EFFECTS: return the age
    public String getAge() {
        return accAge;
    }

    //EFFECTS: return the legal age of flight
    public static int getLegalAgeOfFlight() {
        return legalAgeOfFlight;
    }
}