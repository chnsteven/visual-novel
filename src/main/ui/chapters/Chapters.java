package ui.chapters;

import javax.swing.*;

public interface Chapters {

    //MODIFIES: JLabel;
    //EFFECTS: sets the text of JLabel to a desire plot;
    void tellStory(JLabel dialogContent);

    //MODIFIES: JLabel;
    //EFFECTS: sets the text of JLabel to a desire plot after making a selection;
    void tellAfterStory(JLabel dialogContent, JComboBox dialogChoices);

    //REQUIRES: elements of ComboBoxModel does not exceed 3;
    //MODIFIES: JComboBox<String>, DefaultComboBoxModel;
    //EFFECTS: Given a JComboBox, remove all elements previously inside of it,
    // then add elements to the ComboBoxModel until reaches 3 elements;
    void multipleChoice(JComboBox<String> dialogChoices, DefaultComboBoxModel choicesModel);
}
