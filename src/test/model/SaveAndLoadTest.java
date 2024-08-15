package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Account;
import ui.VisualNovel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.VisualNovel.load;
import static ui.VisualNovel.save;

public class SaveAndLoadTest {
    private Account acc;

    @BeforeEach
    public void setUp() {
        acc = new Account();

    }

    @Test
    public void testSaveAndLoad() {
        List<String> saveFile = new ArrayList<>();
        acc.setName("S");
        acc.setGender("M");
        acc.setAge("0");
        saveFile.add(acc.getName());
        saveFile.add(acc.getGender());
        saveFile.add(acc.getAge());
        save(saveFile);
        load();
        assertEquals("S", (VisualNovel.loadFile.get(0)));
        assertEquals("M", (VisualNovel.loadFile.get(1)));
        assertEquals("0", (VisualNovel.loadFile.get(2)));

        List<String> saveFile2 = new ArrayList<>();
        acc.setName("Sophie");
        acc.setAge("17");
        acc.setGender("Female");
        saveFile2.add(acc.getName());
        saveFile2.add(acc.getGender());
        saveFile2.add(acc.getAge());
        save(saveFile2);
        load();
        assertEquals("Sophie", (VisualNovel.loadFile.get(0)));
        assertEquals("Female", (VisualNovel.loadFile.get(1)));
        assertEquals("17", (VisualNovel.loadFile.get(2)));
    }
}
