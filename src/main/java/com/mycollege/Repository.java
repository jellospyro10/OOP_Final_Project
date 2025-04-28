package com.mycollege;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Handles CSV-based persistence for Members and Events.
 */
public class Repository {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    /**
     * Loads members from a CSV file (name,email per line).
     */
    public static List<Member> loadMembers(Path path) throws IOException {
        List<Member> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                list.add(new Member(parts[0], parts[1]));
            }
        }
        return list;
    }

    /**
     * Saves members to a CSV file (name,email per line).
     */
    public static void saveMembers(Path path, List<Member> members) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member m : members) {
                writer.write(m.getName() + "," + m.getEmail());
                writer.newLine();
            }
        }
    }

    /**
     * Loads events from a CSV file. Format per line:
     * type,dateTime,location,capacity,detail
     */
    public static List<Event> loadEvents(Path path) throws IOException {
        List<Event> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",", 5);
                String type = parts[0];
                LocalDateTime dt = LocalDateTime.parse(parts[1], fmt);
                String loc = parts[2];
                int cap = Integer.parseInt(parts[3]);
                String detail = parts[4];
                if ("CarMeet".equals(type)) {
                    list.add(new CarMeetEvent(dt, loc, cap, detail));
                } else if ("CarShow".equals(type)) {
                    List<String> cats = Arrays.asList(detail.split(";"));
                    list.add(new CarShowEvent(dt, loc, cap, cats));
                }
            }
        }
        return list;
    }

    /**
     * Saves events to a CSV file. Format per line:
     * type,dateTime,location,capacity,detail
     */
    public static void saveEvents(Path path, List<Event> events) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Event e : events) {
                String type = e instanceof CarMeetEvent ? "CarMeet" : "CarShow";
                StringBuilder sb = new StringBuilder();
                sb.append(type).append(",")
                        .append(e.getDateTime().format(fmt)).append(",")
                        .append(e.getLocation()).append(",")
                        .append(e.getCapacity()).append(",");
                if (e instanceof CarMeetEvent) {
                    sb.append(((CarMeetEvent) e).getTheme());
                } else {
                    sb.append(String.join(";", ((CarShowEvent) e).getAwardCategories()));
                }
                writer.write(sb.toString());
                writer.newLine();
            }
        }
    }
}
