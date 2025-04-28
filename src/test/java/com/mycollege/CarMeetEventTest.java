package com.mycollege;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CarMeetEventTest {
    @Test
    void testAddParticipantAndCompareTo() {
        LocalDateTime now = LocalDateTime.now();
        CarMeetEvent e1 = new CarMeetEvent(now, "Loc1", 2, "Speedsters");
        CarMeetEvent e2 = new CarMeetEvent(now.plusDays(1), "Loc2", 2, "Classics");

        Member m1 = new Member("M1", "m1@example.com");
        e1.addParticipant(m1);
        assertEquals(1, e1.getAttendees().size());

        e1.addParticipant("m2@example.com");
        assertEquals(2, e1.getAttendees().size());

        assertThrows(IllegalStateException.class, () ->
                e1.addParticipant(new Member("M3", "m3@example.com"))
        );

        assertTrue(e1.compareTo(e2) < 0);
        assertTrue(e2.compareTo(e1) > 0);
    }

    @Test
    void testDisplayDetails() {
        LocalDateTime d = LocalDateTime.of(2025,1,1,10,0);
        CarMeetEvent e = new CarMeetEvent(d, "TestLoc", 5, "Retro");
        String details = e.displayDetails();
        assertTrue(details.contains("Car Meet Event on " + d.toString()));
        assertTrue(details.contains("Theme: Retro"));
        assertTrue(details.contains("Attendees: 0"));
    }
}
