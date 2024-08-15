package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestException {
    private String accName;
    private String accSex;
    private int accAge;
    private Account acc;


    @BeforeEach
    public void setUp() {
        acc = new Account();
    }

    @Test
    public void testIsIntegerNumberFormatException() {
        try {
            assertFalse(Account.isInteger(""));
        } catch (NumberFormatException e) {
            //expected;
        } catch (NullPointerException e) {
            fail("NullPointerException caught");
        }
    }

    @Test
    public void testIsIntegerNullPointerException() {
        try {
            assertFalse(Account.isInteger(null));
        } catch (NumberFormatException e) {
            fail("NumberFormatException caught");
        } catch (NullPointerException e) {
            //expected;
        }
    }

    @Test
    public void testIsIntegerNoException() {
        try {
            assertTrue(Account.isInteger("10"));
        } catch (Exception e) {
            fail("No exception should be caught.");
        }
    }
}
