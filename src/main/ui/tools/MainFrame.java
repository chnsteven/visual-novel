package ui.tools;

import model.Message;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;

    private ArrayList<JLabel> images = new ArrayList<>();
    private Toolbar toolbar;
    private DialogPanel dialogPanel;
    private int clicked = 0;


    public MainFrame() {
        super("MY VISUAL NOVEL");
        createListOfImages();
        createJComponents();
        addJComponents();
        setConditions();

        dialogPanel.setDialogListener(new DialogListener() {
            @Override
            public void gameOver() {
                Music gameOverTheme = new Music("Game Over Theme.wav");
                gameOverTheme.playMusic();
                Message.gameOver();
                shutDown();
            }

            @Override
            public void win() {
                Music winTheme = new Music("Win.wav");
                winTheme.playMusic();
                Message.win();
                shutDown();
            }

            @Override
            public void nextImage() {
                createNextImage();
            }

            @Override
            public void previousImage() {
                createPreviousImage();
            }
        });
    }



    private void shutDown() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void createJComponents() {
        toolbar = new Toolbar();
        dialogPanel = new DialogPanel();
    }

    private void addJComponents() {
        add(toolbar, BorderLayout.NORTH);
        add(dialogPanel, BorderLayout.PAGE_END);
    }

    private void setConditions() {
        setSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createNextImage() {
        if (clicked == 0) {
            add(images.get(0), BorderLayout.CENTER);
            clicked++;
        } else {
            remove(images.get(clicked - 1));
            add(images.get(clicked), BorderLayout.CENTER);
            clicked++;
        }
        reset();
    }

    private void createPreviousImage() {
        if (clicked == 2) {
            remove(images.get(1));
            add(images.get(0), BorderLayout.CENTER);
            clicked--;
        } else if (clicked == 3) {
            remove(images.get(2));
            add(images.get(1), BorderLayout.CENTER);
            clicked--;
        } else if (clicked == 4) {
            remove(images.get(3));
            add(images.get(2), BorderLayout.CENTER);
            clicked--;
        } else if (clicked == 5) {
            remove(images.get(4));
            add(images.get(3), BorderLayout.CENTER);
            clicked--;
        }
        reset();
    }

    private void reset() {
        validate();
        repaint();
    }

    private void createListOfImages() {
        try {
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/YVR.jpg")))));
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/Pom.jpg")))));
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/AdorableGirl.jpg")))));
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/Lecture Hall.jpg")))));
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/Night.jpg")))));
            images.add(new JLabel(new ImageIcon(ImageIO.read(new File("data/fireworks.jpg")))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
