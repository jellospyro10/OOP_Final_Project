package com.mycollege;

import java.util.*;

/**
 * Represents a member with a collection of cars.
 */
public class Member extends Person {
    private List<Car> cars;

    /**
     * Constructs a Member.
     * @param name  member's name
     * @param email member's email
     */
    public Member(String name, String email) {
        super(name, email);
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() + ", Cars Owned: " + cars.size();
    }
}
