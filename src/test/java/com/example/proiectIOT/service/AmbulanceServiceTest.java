package com.example.proiectIOT.service;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.repository.AmbulanceRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

//@AllArgsConstructor
class AmbulanceServiceTest{

    //protected AmbulanceRepository ambulanceRepository;
    AmbulanceService ambulanceService;


    @Before
    public void init(){
        ambulanceService = Mockito.mock(AmbulanceService.class);
        //ambulanceService = new AmbulanceService();
    }


    @Test
    public void detectAmbulanceForBadIndices() {
        //boolean expectedValue = false;
        boolean actual = ambulanceService.detectAmbulance(
                new Ambulance("IS21NBB",
                        false,
                        0.0, 0.0, 0.0));
        assertFalse(actual);

    }

    @Test
    public void getAllAmbulances() {
    }

    @Test
    void insertAmbulance() {
    }

    @Test
    void updateAmbulance() {
    }

    @Test
    void getAmbulance() {
    }

    @Test
    void deleteAmbulance() {
    }
}