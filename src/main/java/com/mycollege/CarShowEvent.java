
package com.mycollege;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a car show event with award categories.
 */
public class CarShowEvent extends Event {
    private List<String> awardCategories;

    /**
     * Constructs a CarShowEvent.
     */
    public CarShowEvent(LocalDateTime dateTime, String location, int capacity, List<String> awardCategories) {
        super(dateTime, location, capacity);
        this.awardCategories = awardCategories;
    }

    public List<String> getAwardCategories() { return awardCategories; }

    @Override
    public String displayDetails() {
        return "Car Show Event on " + dateTime +
                " at " + location +
                ", Categories: " + awardCategories +
                ", Attendees: " + attendees.size();
    }
}
