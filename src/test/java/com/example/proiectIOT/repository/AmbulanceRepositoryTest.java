package com.example.proiectIOT.repository;

import com.example.proiectIOT.model.Ambulance;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AmbulanceRepositoryTest {

    @Autowired
    private AmbulanceRepository underTest;

    @Test
    void findAmbulanceByLicensePlate() {
        //given
        String plate = "SV 07 WOQ";
        Ambulance amb1 = new Ambulance(plate, false, 0.08, -188.05, 96.04);
        underTest.save(amb1);

        //when



    }

}