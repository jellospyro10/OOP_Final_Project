package com.mycollege;

import java.time.LocalDateTime;

/**
 * Represents a themed car meet event.
 */
public class CarMeetEvent extends Event {
    private String theme;

    /**
     * Constructs a CarMeetEvent.
     * @param dateTime date and time
     * @param location location
     * @param capacity maximum attendees
     * @param theme theme of the meet
     */
    public CarMeetEvent(LocalDateTime dateTime, String location, int capacity, String theme) {
        super(dateTime, location, capacity);
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String displayDetails() {
        return "Car Meet Event on " + dateTime + " at " + location +
                ", Theme: " + theme + ", Attendees: " + attendees.size();
    }
}
