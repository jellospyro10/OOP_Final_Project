package com.mycollege;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class OrganizerTest {
    @Test
    void testNotifyAndDisplayInfo() {
        Organizer org = new Organizer("Alice", "alice@example.com");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        org.notify("Event updated");
        assertTrue(outContent.toString().contains("Notification to Organizer [Alice]: Event updated"));

        assertEquals("Name: Alice, Email: alice@example.com (Organizer)", org.displayInfo());
    }
}
