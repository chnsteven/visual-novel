package ui.tools;

import ui.VisualNovel;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {
    private JButton btnProfile;
    private JButton btnNew;
    private JButton btnPlay;
    private JButton btnStop;

    public Toolbar() {
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createEtchedBorder());
        createButtons();

        Music backgroundMusic = new Music("Scene of a Street Corner.wav");
        btnNew.addActionListener(e -> VisualNovel.beginStory());
        btnProfile.addActionListener(e -> VisualNovel.printProfile());
        btnPlay.addActionListener(e -> backgroundMusic.playMusic());
        btnStop.addActionListener(e -> backgroundMusic.stopPlayingMusic());
    }

    private void createButtons() {
        btnNew = new JButton("NEW");
        btnProfile = new JButton("PROFILE");
        btnPlay = new JButton("PLAY BACKGROUND MUSIC");
        btnStop = new JButton("STOP BACKGROUND MUSIC");

        add(btnNew);
        add(btnProfile);
        add(btnPlay);
        add(btnStop);
    }

}
