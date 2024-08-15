package ui.chapters;

import javax.swing.*;

public class Chapter2 implements Chapters {

    public Chapter2(JLabel dialogContent, JComboBox dialogChoices, DefaultComboBoxModel choicesModel) {
        tellStory(dialogContent);
        multipleChoice(dialogChoices, choicesModel);
    }

    public Chapter2(JLabel dialogContent, JComboBox dialogChoices) {
        tellAfterStory(dialogContent, dialogChoices);
    }

    @Override
    public void tellStory(JLabel dialogContent) {
        dialogContent.setText("<html>You noticed that you spent too much time fooling around with your phone. "
                + "You put it aside and redrew your attention towards the screen.<br/> "
                + "There was a girl approaching from your back and sat in the next row at your front. "
                + "You were attracted by her. At this moment, you decide to: </html>");
    }

    @Override
    public void tellAfterStory(JLabel dialogContent, JComboBox dialogChoices) {
        int dialogIndex = dialogChoices.getSelectedIndex();
        switch (dialogIndex) {
            default:
                dialogContent.setText("<html>She refused you immediately. "
                        + "She showed disgust towards you and left the seat along with her backpack. "
                        + " you got rejected.</html>");
                break;
            case 1:
                dialogContent.setText("<html>Although she hesitated for a moment, "
                        + "she still accepted your friend request. <br/>"
                        + "You wanted to ask her out after class but you were kind of afraid of being rejected. "
                        + "Instead, you ended the conversation and looked back to the screen.</html>");
                break;
            case 2:
                dialogContent.setText("<html>You turned your attention away from that girl, "
                        + "kept on listening to the lecture. ");
                break;
        }

    }

    @Override
    public void multipleChoice(JComboBox<String> dialogChoices, DefaultComboBoxModel choicesModel) {
        dialogChoices.removeAllItems();
        choicesModel.addElement("Confidently ask her out after lecture is over");
        choicesModel.addElement("Politely ask for phone number or Facebook friend");
        choicesModel.addElement("Focuses on the lecture slides and ignore her from now on");
    }
}
