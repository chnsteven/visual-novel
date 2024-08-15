package ui;

import model.Message;
import ui.tools.MainFrame;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class VisualNovel extends JFrame implements java.io.Serializable {
    public static Account acc;
    private static String filename = "file.ser";
    private static List<String> saveFile = new ArrayList<>();
    public static List loadFile = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }


    //MODIFIES: saveFile
    //EFFECTS: start by initializing a new account, after the initialization is finished;
    // store all information in to the saveFile
    public static void beginStory() {
        initiate();
        addToSaveFile();
        save(saveFile);
    }

    //REQUIRES: saveFile != null
    //MODIFIES: List
    //EFFECTS: load all elements inside saveFile then return the account previously created
    public static Account getInfo() {
        load();
        restoreFromLoadFile();
        return acc;
    }

    public static void printProfile() {
        Message.restoreInfoMsg(acc);
    }

    private static void restoreFromLoadFile() {
        acc = new Account();
        acc.setName((String) loadFile.get(0));
        acc.setGender((String) loadFile.get(1));
        acc.setAge((String) loadFile.get(2));
    }

    private static void initiate() {
        acc = new Account();
        acc.setUserInfo();
    }

    private static void addToSaveFile() {
        saveFile.add(acc.getName());
        saveFile.add(acc.getGender());
        saveFile.add(acc.getAge());
    }

    //MODIFIES: saveFile
    //EFFECTS: write object into a file using serialization
    public static void save(Object obj) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(obj);
            out.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("Exception is caught!");
        }
    }

    //MODIFIES: loadFile
    //EFFECTS: read object from file using serialization
    public static List load() {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            loadFile = (List) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return loadFile;
    }
}


