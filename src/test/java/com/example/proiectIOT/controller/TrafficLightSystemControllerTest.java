package com.example.proiectIOT.controller;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.proiectIOT.service.TrafficLightSystemService;
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

@ContextConfiguration(classes = {TrafficLightSystemController.class})
@ExtendWith(SpringExtension.class)
public class TrafficLightSystemControllerTest {
    @Autowired
    private TrafficLightSystemController trafficLightSystemController;

    @MockBean
    private TrafficLightSystemService trafficLightSystemService;

    @Test
    public void testDeleteTrafficSystem() throws Exception {
        doNothing().when(this.trafficLightSystemService).deleteSystem(anyString());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/trafficlightsystems/delete/{id}",
                "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.trafficLightSystemController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testGetSystemByID() throws Exception {
        when(this.trafficLightSystemService.getSystem(anyString())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/trafficlightsystems/get/{id}",
                "42");
        MockMvcBuilders.standaloneSetup(this.trafficLightSystemController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    @Test
    public void testGetSystemByID2() throws Exception {
        when(this.trafficLightSystemService.getSystem(anyString())).thenReturn("42");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/trafficlightsystems/get/{id}", "42");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.trafficLightSystemController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }
}

