package com.mycollege;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void testInitialCarsAndDisplayInfo() {
        Member m = new Member("Bob", "bob@example.com");
        assertEquals(0, m.getCars().size());
        assertEquals("Name: Bob, Email: bob@example.com, Cars Owned: 0", m.displayInfo());
    }
}
