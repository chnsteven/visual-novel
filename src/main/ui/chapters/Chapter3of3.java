package ui.chapters;

import javax.swing.*;

public class Chapter3of3 implements Chapters {

    public Chapter3of3(JLabel dialogContent, JComboBox dialogChoices, DefaultComboBoxModel choicesModel) {
        tellStory(dialogContent);
        multipleChoice(dialogChoices, choicesModel);
    }

    public Chapter3of3(JLabel dialogContent, JComboBox dialogChoices) {
        tellAfterStory(dialogContent, dialogChoices);
    }

    @Override
    public void tellStory(JLabel dialogContent) {
        dialogContent.setText("<html>At the end of the day you left your last lecture and went back home right away. "
                + "<br/>It was dark in the night so you decided to take a short passage that "
                + "you just found out few days ago.  <br/>"
                + "The passage was too silent, you were scared and reached out to your phone, you dialed: </html>");
    }

    @Override
    public void tellAfterStory(JLabel dialogContent, JComboBox dialogChoices) {
        switch (dialogChoices.getSelectedIndex()) {
            default:
                dialogContent.setText("<html>She started to blah and blah and blah and you were annoyed by it. "
                        + "You hanged up the phone after just a minute and kept walking back. <br/> "
                        + "You heard someone walking really fast towards you, but it was too late to react."
                        + "You got kidnapped. </html>");
                break;
            case 1:
                dialogContent.setText("<html> Your friend did not reply the call. Suddenly, "
                        + "You heard someone walking really fast towards you, but it was too late to react."
                        + "You got kidnapped. </html>");
                break;
            case 2:
                dialogContent.setText("<html> The police thought you were drunk, "
                        + "but you persisted that there's someone stalking you. <br/>"
                        + "The police sent a guard to you and you safely arrived home.");
                break;
        }
    }

    @Override
    public void multipleChoice(JComboBox<String> dialogChoices, DefaultComboBoxModel choicesModel) {
        dialogChoices.removeAllItems();
        choicesModel.addElement("Your mother");
        choicesModel.addElement("Your friend");
        choicesModel.addElement("911");

    }
}
