package com.example.proiectIOT.service;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.repository.AmbulanceRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import junit.framework.TestCase;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

//@AllArgsConstructor
@ContextConfiguration(classes = {AmbulanceService.class})
@ExtendWith(SpringExtension.class)
class AmbulanceServiceTest {

    @MockBean
    private AmbulanceRepository ambulanceRepository;

    //protected AmbulanceRepository ambulanceRepository;
    AmbulanceService ambulanceService;


    @Before
    public void init() {
        ambulanceService = Mockito.mock(AmbulanceService.class);
        //ambulanceService = new AmbulanceService();
    }


    @Test
    public void detectAmbulanceTestForBadIndices() {
        //boolean expectedValue = false;
        boolean actual = ambulanceService.detectAmbulance(
                new Ambulance("IS21NBB",
                        false,
                        0.0, 0.0, 0.0));
        assertFalse(actual);

    }

    @Test
    public void getAllAmbulancesCanGetListTest() {
        List<Ambulance> actual = ambulanceService.getAllAmbulances();
        if (actual instanceof List) {
            List list = (List) actual;
            for (Object e : list) {
                assertTrue(e instanceof Ambulance);

            }
        }
        //assertTrue(actual instanceof List<Ambulance>);
    }

    @Test
    public void testDeleteAmbulance() {
        doNothing().when(this.ambulanceRepository).deleteById(anyString());
        this.ambulanceService.deleteAmbulance("42");
        verify(this.ambulanceRepository).deleteById(anyString());
        assertTrue(this.ambulanceService.getAllAmbulances().isEmpty());
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