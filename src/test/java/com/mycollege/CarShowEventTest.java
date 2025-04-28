package com.mycollege;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class CarShowEventTest {
    @Test
    void testDisplayDetails() {
        LocalDateTime d = LocalDateTime.of(2025,5,20,14,30);
        CarShowEvent e = new CarShowEvent(d, "Showroom", 10,
                Arrays.asList("Best Paint","Best Engine")
        );
        String details = e.displayDetails();
        assertTrue(details.contains("Car Show Event on " + d.toString()));
        assertTrue(details.contains("Categories: [Best Paint, Best Engine]"));
        assertTrue(details.contains("Attendees: 0"));
    }
}
