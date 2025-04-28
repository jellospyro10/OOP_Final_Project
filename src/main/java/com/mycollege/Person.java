package com.mycollege;

public abstract class Person {
    protected String name;
    protected String email;

    /**
     * Constructs a new Person.
     *
     * @param name  person's name
     * @param email person's email
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Returns summary info for this person.
     *
     * @return formatted name and email
     */
    public String displayInfo() {
        return "Name: " + name + ", Email: " + email;
    }
}