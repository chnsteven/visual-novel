package ui.chapters;

import ui.Account;
import ui.VisualNovel;
import ui.tools.Music;

import javax.swing.*;

public class Chapter1 implements Chapters {
    private Music shallWePom = new Music("Shall We Pom.wav");
    private String legalAgeOfFlightString = "";
    private String afterStory = "Anyway, you kept listening to the professor. <br/>"
            + "The introduction to the course was dull; all he did was reading off the slides of syllabus. <br/>"
            + "You felt boring, so you started to play on your phone. ";

    public Chapter1(JLabel dialogContent, JComboBox dialogChoices, DefaultComboBoxModel choicesModel) {
        tellStory(dialogContent);
        multipleChoice(dialogChoices, choicesModel);
    }

    public Chapter1(JLabel dialogContent, JComboBox dialogChoices) {
        tellAfterStory(dialogContent, dialogChoices);
    }


    public void tellStory(JLabel dialogContent) {
        decideLegalAge();
        dialogContent.setText("<html>This was the first time you travel to Vancouver. "
                + "The fascinating view from the Vancouver International Airport was extraordinary. <br/>"
                + legalAgeOfFlightString
                + "As a newcomer to Vancouver, you were very unfamiliar with the "
                + "surroundings. But after few days of adaptation, <br/>"
                + "you finally settled down and was ready for a brand new start. "
                + "The very first classroom you attended on the very first day of university was: </html>");
    }

    private void decideLegalAge() {
        if (isOverLegalAge()) {
            legalAgeOfFlightString = "Since you were already above the legal age, "
                    + "you were all by yourself when you land in Vancouver. <br/>";
        } else if (!isOverLegalAge()) {
            legalAgeOfFlightString = "Since you were not above the legal age, "
                    + "your parents accompanied you all the way from your hometown.<br/>";
        }
    }

    private boolean isOverLegalAge() {
        return Integer.parseInt(VisualNovel.acc.getAge()) >= Account.getLegalAgeOfFlight();
    }

    public void multipleChoice(JComboBox<String> dialogChoices, DefaultComboBoxModel choicesModel) {
        dialogChoices.removeAllItems();
        choicesModel.addElement("Mathematics");
        choicesModel.addElement("CPSC");
        choicesModel.addElement("Literature");
    }

    public void tellAfterStory(JLabel dialogContent, JComboBox dialogChoices) {
        shallWePom.playMusic();
        switch (dialogChoices.getSelectedIndex()) {
            default:
                dialogContent.setText("<html>Ah... You must be very fond of Math!<br/>" + afterStory);
                break;
            case 1:
                dialogContent.setText("<html>Ah... You must be very fond of Computer Science!<br/>" + afterStory);
                break;
            case 2:
                dialogContent.setText("<html>Ah... You must be very fond of Literature!<br/>" + afterStory);
                break;
        }
        try {
            playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playGame() {
        Object[] options = {"I want to quit"};
        int x = JOptionPane.showOptionDialog(null,
                "Enjoy Your Game......",
                "Gaming",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        if (x == 0) {
            shallWePom.stopPlayingMusic();
        }
    }
}
