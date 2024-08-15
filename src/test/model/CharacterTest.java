package model;

import model.character.Felicity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    private Felicity fel;

    @BeforeEach
    public void setUp() {
        fel = new Felicity();
    }

    @Test
    public void testGetName(){
        assertEquals("Felicity", fel.getName());
    }
    @Test
    public void testgetDorm(){
        assertEquals("Totem Park", fel.getDorm());
    }
    @Test
    public void testGetRace(){
        assertEquals("Asian", fel.getRace());
    }
    @Test
    public void testGetHeight(){
        assertEquals(165, fel.getHeight());
    }
    @Test
    public void testGetGrade(){
        assertEquals("First Year Student", fel.getGrade());
    }
    @Test
    public void getFavoriteSnack(){
        assertEquals("Candy", fel.getFavoriteSnack());
    }
}
