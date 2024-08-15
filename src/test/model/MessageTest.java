package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Account;

public class MessageTest {

    @BeforeEach
    public void setUp() {
        new Message();
    }

    @Test
    public void testMessage() {
        Message.quitMsg();
        Message.warningMsg();
        Message.invalidInputMsg();
        Message.restoreInfoMsg(new Account());
        Message.gameOver();
    }
}
