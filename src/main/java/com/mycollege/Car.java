package com.mycollege;
/**
 * Represents a car owned by a member.
 */
public class Car {
    private final String make;
    private final String model;
    private final int year;

    /**
     * Constructs a new Car.
     * @param make  car manufacturer
     * @param model car model
     * @param year  year of manufacture
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
