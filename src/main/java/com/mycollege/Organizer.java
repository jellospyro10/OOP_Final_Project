package com.mycollege;

public class Organizer extends Person implements Notifiable {
    /**
     * Constructs an Organizer.
     * @param name  organizer's name
     * @param email organizer's email
     */
    public Organizer(String name, String email) {
        super(name, email);
    }

    @Override
    public void notify(String message) {
        System.out.println("Notification to Organizer [" + name + "]: " + message);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + " (Organizer)";
    }
}
