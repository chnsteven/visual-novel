package ui.tools;

import ui.VisualNovel;
import ui.chapters.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class DialogPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel dialogContent;
    private JComboBox<String> dialogChoices;
    private JButton nextBtn;
    private JButton previousBtn;
    private GridBagConstraints gc;
    private DefaultComboBoxModel<String> choicesModel;
    private int clicked = 0;

    private DialogListener dialogListener;


    public DialogPanel() {
        try {
            setDimensionOfDialogPanel();
            addComponents();
            createBorder();
            createDialogChoices(choicesModel, "");
            createLayout();

            nextBtn.addActionListener(e -> {
                nameLabel.setText(VisualNovel.getInfo().getName() + ": ");
                nextChapter();
            });

            previousBtn.addActionListener(e -> {
                nameLabel.setText(VisualNovel.getInfo().getName() + ": ");
                previousChapter();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setDialogListener(DialogListener listener) {
        this.dialogListener = listener;
    }

    private void previousChapter() {
        dialogListener.previousImage();
        switch (--clicked) {
            case 1:
                new Chapter1(dialogContent, dialogChoices, choicesModel);
                break;
            case 2:
                new Chapter1(dialogContent, dialogChoices);
                break;
            case 3:
                new Chapter2(dialogContent, dialogChoices, choicesModel);
                break;
            default:
                chapter3();
                break;
        }
    }

    private void nextChapter() {
        dialogListener.nextImage();
        switch (++clicked) {
            case 1:
                new Chapter1(dialogContent, dialogChoices, choicesModel);
                break;
            case 2:
                new Chapter1(dialogContent, dialogChoices);
                break;
            case 3:
                new Chapter2(dialogContent, dialogChoices, choicesModel);
                break;
            default:
                chapter3();
                break;
        }
    }

    private void chapter3FailingPt(int index) {
        if (dialogChoices.getSelectedIndex() == index) {
            if (dialogListener != null) {
                dialogListener.gameOver();
            }
        }
    }

    private void chapter3() {
        switch (clicked) {
            case 4:
                new Chapter2(dialogContent, dialogChoices);
                break;
            case 5:
                getChapter3Branch(dialogChoices.getSelectedIndex());
                break;
            case 6:
                getChapter3AfterStoryBranch(dialogChoices.getSelectedIndex());
                break;
            case 7:
                dialogContent.setText("Hello Once Again");
                break;
            default:
                break;
        }
    }

    private void getChapter3AfterStoryBranch(int index) {
        switch (index) {
            default:
                dialogListener.gameOver();
                break;
            case 1:
            case 2:
                dialogListener.win();
                break;

        }
        new Chapter3of2(dialogContent, dialogChoices);
    }

    private void getChapter3Branch(int index) {
        switch (index) {
            default:
                chapter3FailingPt(0);
                break;
            case 1:
                new Chapter3of2(dialogContent, dialogChoices, choicesModel);
                break;
            case 2:
                new Chapter3of3(dialogContent, dialogChoices, choicesModel);
        }
    }

    private void addComponents() {
        nameLabel = new JLabel();
        dialogContent = new JLabel();
        nextBtn = new JButton("next");
        previousBtn = new JButton("previous");
        choicesModel = new DefaultComboBoxModel<>();

        setItalicFont(nameLabel);
        setItalicFont(dialogContent);
        setItalicFont(nextBtn);
        setItalicFont(previousBtn);
    }

    private void setItalicFont(JComponent jc) {
        jc.setFont(new Font("Lobster", Font.ITALIC, 14));
    }

    private void createLayout() {
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();

        gridLayoutFirstRow();
        gridLayoutSecondRow();
    }

    private void gridLayoutDefaultParam() {
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
    }

    private void gridLayoutFirstRow() {
        gridLayoutDefaultParam();
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 0.1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.weightx = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(dialogContent, gc);

    }

    private void gridLayoutSecondRow() {
        gridLayoutDefaultParam();
        gc.gridy++;
        gc.gridx = 2;
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        add(nextBtn, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.PAGE_END;
        add(dialogChoices, gc);

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        add(previousBtn, gc);
    }

    private void createDialogChoices(DefaultComboBoxModel choicesModel, String choiceString) {
        dialogChoices = new JComboBox<>();
        addChoices(choicesModel, choiceString);
        dialogChoices.setModel(choicesModel);
        dialogChoices.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setItalicFont(dialogChoices);
    }

    private void addChoices(DefaultComboBoxModel choicesModel, String choiceString) {
        choicesModel.addElement(choiceString);
    }

    private void createBorder() {
        TitledBorder innerBorder = BorderFactory.createTitledBorder("Dialog");
        innerBorder.setTitleFont(new Font("Lobster", Font.ITALIC, 18));
        innerBorder.setTitleJustification(TitledBorder.CENTER);

        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    private void setDimensionOfDialogPanel() {
        Dimension dim = getPreferredSize();
        dim.height = 250;
        setPreferredSize(dim);
    }
}

