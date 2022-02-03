package com.example.proiectIOT.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.example.proiectIOT.repository.TrafficLightSystemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrafficLightSystemService.class})
@ExtendWith(SpringExtension.class)
public class TrafficLightSystemServiceTest {
    @MockBean
    private TrafficLightSystemRepository trafficLightSystemRepository;

    @Autowired
    private TrafficLightSystemService trafficLightSystemService;

    @Test
    public void testDeleteSystem() {
        doNothing().when(this.trafficLightSystemRepository).deleteById(anyString());
        this.trafficLightSystemService.deleteSystem("42");
        verify(this.trafficLightSystemRepository).deleteById(anyString());
        assertTrue(this.trafficLightSystemService.getAllSystems().isEmpty());
    }
}

