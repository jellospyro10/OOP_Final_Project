package com.mycollege;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract representation of an event with scheduling and attendees.
 */
public abstract class Event implements Comparable<Event> {
    protected LocalDateTime dateTime;
    protected String location;
    protected Set<Member> attendees;
    protected int capacity;

    /**
     * Constructs a new Event.
     * @param dateTime date and time of event
     * @param location location of event
     * @param capacity maximum number of attendees
     */
    public Event(LocalDateTime dateTime, String location, int capacity) {
        this.dateTime = dateTime;
        this.location = location;
        this.capacity = capacity;
        this.attendees = new HashSet<>();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Member> getAttendees() {
        return attendees;
    }

    /**
     * Returns full details of this event.
     * @return descriptive string
     */
    public abstract String displayDetails();

    /**
     * Adds a member to this event.
     * @param m the member to add
     * @throws IllegalStateException if event is full
     */
    public void addParticipant(Member m) {
        if (attendees.size() >= capacity) {
            throw new IllegalStateException("Event is full");
        }
        attendees.add(m);
    }

    /**
     * Overloaded: add a participant via email (auto-creates a member).
     * @param memberEmail email of the participant
     */
    public void addParticipant(String memberEmail) {
        Member m = new Member(memberEmail, memberEmail);
        addParticipant(m);
    }

    @Override
    public int compareTo(Event other) {
        return this.dateTime.compareTo(other.dateTime);
    }
}
