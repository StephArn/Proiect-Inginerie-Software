package com.example.proiectIOT.controller;

import com.example.proiectIOT.service.AmbulanceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;

@ContextConfiguration(classes = {AmbulanceController.class})
@ExtendWith(SpringExtension.class)
class AmbulanceControllerTest {

    @Autowired
    private AmbulanceController ambulanceController;

    @MockBean
    private AmbulanceService ambulanceService;

    @Test
    void fetchAllAmbulances() {
    }

    @Test
    void addAmbulance() {
    }

    @Test
    void updateAmbulance() {
    }

    @Test
    void getAmbulanceByLicensePlate() {
    }

    @Test
    public void testDeleteAmbulance() throws Exception {
        doNothing().when(this.ambulanceService).deleteAmbulance(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/ambulances/{id}", "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.ambulanceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteAmbulance() {
    }
}