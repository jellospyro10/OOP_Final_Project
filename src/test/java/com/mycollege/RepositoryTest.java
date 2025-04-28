package com.mycollege;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    void testSaveAndLoadMembers(@TempDir Path tempDir) throws Exception {
        Path file = tempDir.resolve("members.csv");
        List<Member> members = Arrays.asList(
                new Member("Alice", "a@example.com"),
                new Member("Bob", "b@example.com")
        );
        Repository.saveMembers(file, members);
        assertTrue(Files.exists(file));
        List<Member> loaded = Repository.loadMembers(file);
        assertEquals(2, loaded.size());
        assertEquals("Alice", loaded.get(0).getName());
        assertEquals("b@example.com", loaded.get(1).getEmail());
    }

    @Test
    void testSaveAndLoadEvents(@TempDir Path tempDir) throws Exception {
        Path file = tempDir.resolve("events.csv");
        LocalDateTime dt1 = LocalDateTime.of(2025, 6, 1, 10, 0);
        LocalDateTime dt2 = LocalDateTime.of(2025, 7, 15, 14, 30);
        List<Event> events = Arrays.asList(
                new CarMeetEvent(dt1, "Park", 5, "Vintage"),
                new CarShowEvent(dt2, "Expo", 10, Arrays.asList("Best in Show","People's Choice"))
        );
        Repository.saveEvents(file, events);
        assertTrue(Files.exists(file));

        List<Event> loaded = Repository.loadEvents(file);
        assertEquals(2, loaded.size());
        Event e1 = loaded.get(0);
        assertTrue(e1 instanceof CarMeetEvent);
        assertEquals(dt1, e1.getDateTime());
        assertEquals("Vintage", ((CarMeetEvent)e1).getTheme());

        Event e2 = loaded.get(1);
        assertTrue(e2 instanceof CarShowEvent);
        assertEquals(2, ((CarShowEvent)e2).getAwardCategories().size());
        assertEquals("People's Choice", ((CarShowEvent)e2).getAwardCategories().get(1));
    }
}
