package com.mycollege;

import java.util.Comparator;

/**
 * Comparator for Member objects, comparing by name.
 */
public class MemberNameComparator implements Comparator<Member> {
    @Override
    public int compare(Member a, Member b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
