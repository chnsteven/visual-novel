package ui.chapters;

import javax.swing.*;

public class Chapter3of2 implements Chapters {
    private static String inevitableStringAfterChoice = "After your 9p.m. lab you still remembered that "
            + "she lives in the dormitory in Totem Park, but you've got nothing in hands. "
            + "Do you still wish to go?";
    private static String stringAfterChoce = "<html>After your 9p.m. lab you still remembered that "
            + "she lives in the dormitory in Totem Park, you've got some sweets and drinks with you <br/>"
            + "so you decided to meet her. Although it was quite late in the night, "
            + "she still had the uniform she wore in the morning on. <br/>"
            + "Surprisingly she likes sweets a lot. "
            + "You listened and showed interest to her gossips about her current roommate. <br/>"
            + "Both of you were happy to talk to each other. "
            + "After that, you went back home alone after saying farewell.</html>";

    public Chapter3of2(JLabel dialogContent, JComboBox dialogChoices, DefaultComboBoxModel choicesModel) {
        tellStory(dialogContent);
        multipleChoice(dialogChoices, choicesModel);
    }

    public Chapter3of2(JLabel dialogContent, JComboBox dialogChoices) {
        tellAfterStory(dialogContent, dialogChoices);
    }


    @Override
    public void tellStory(JLabel dialogContent) {
        dialogContent.setText("<html> Her hair was swinging when she turned her head around, "
                + "you noticed that she has combed her hair up; shinny but dark and straight. <br/>"
                + "You could tell from her skin tone that she must came from an Asian country, "
                + "but you didn't know where exactly. <br/>"
                + "Without hesitation, you asked where she came from, and she replied that she's from Korea. "
                + "After the conversation she told you that she really enjoyed taking to you. <br/>"
                + "You exchanged contacts and left the classroom. Her name's Felicity. "
                + "You realized that there's still an hour before your lab at 6p.m. <br/>"
                + "You decided to spend this time: </html>");
    }

    @Override
    public void tellAfterStory(JLabel dialogContent, JComboBox dialogChoices) {
        int dialogIndex = dialogChoices.getSelectedIndex();
        switch (dialogIndex) {
            default:
                dialogContent.setText(inevitableStringAfterChoice);
                break;
            case 1:
                dialogContent.setText("<html>You took out your phone and dialed her, "
                        + "but she wasn't expecting a call from you. "
                        + "You could tell that she was busy doing something on her own so u decided to hang up. <br/>"
                        + inevitableStringAfterChoice + "</html>");
                break;
            case 2:
                dialogContent.setText(stringAfterChoce);
                break;
        }
    }

    @Override
    public void multipleChoice(JComboBox<String> dialogChoices, DefaultComboBoxModel choicesModel) {
        dialogChoices.removeAllItems();
        choicesModel.addElement("Stay alone and eat dinner");
        choicesModel.addElement("Call Felicity and ask her out");
        choicesModel.addElement("Buy some sweets and drinks");
    }
}
