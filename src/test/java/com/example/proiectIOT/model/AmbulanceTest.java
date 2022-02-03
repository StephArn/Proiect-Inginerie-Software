package com.example.proiectIOT.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AmbulanceTest {
    @Test
    public void testConstructor() {
        Ambulance actualAmbulance = new Ambulance("License Plate", true, 10.0, 10.0, 10.0);

        assertTrue(actualAmbulance.isSensorStatus());
        assertEquals(10.0, actualAmbulance.getMfcc3());
        assertEquals(10.0, actualAmbulance.getMfcc2());
        assertEquals(10.0, actualAmbulance.getMfcc1());
        assertEquals("License Plate", actualAmbulance.getLicensePlate());
    }
}

