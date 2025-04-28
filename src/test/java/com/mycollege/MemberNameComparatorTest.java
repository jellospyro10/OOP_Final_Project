package com.mycollege;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberNameComparatorTest {
    @Test
    void testCompare() {
        Member m1 = new Member("alice", "a@example.com");
        Member m2 = new Member("Bob", "b@example.com");
        Member m3 = new Member("alice", "a2@example.com");

        Comparator<Member> comp = new MemberNameComparator();
        assertTrue(comp.compare(m1, m2) < 0);
        assertTrue(comp.compare(m2, m1) > 0);
        assertEquals(0, comp.compare(m1, m3));
    }
}
