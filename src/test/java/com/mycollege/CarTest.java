package com.mycollege;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCarGettersAndToString() {
        Car car = new Car("Toyota", "Camry", 2020);
        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2020, car.getYear());
        assertEquals("2020 Toyota Camry", car.toString());
    }
}
