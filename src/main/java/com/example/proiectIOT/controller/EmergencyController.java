package com.example.proiectIOT.controller;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.model.TrafficLightSystem;
import com.example.proiectIOT.service.AmbulanceService;
import com.example.proiectIOT.service.TrafficLightSystemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/emergency")
@AllArgsConstructor
public class EmergencyController {

    private final AmbulanceService ambulanceService;
    private final TrafficLightSystemService trafficLightSystemService;

    @PostMapping
    public ResponseEntity handleEmergency(@RequestBody Ambulance amb, @RequestBody TrafficLightSystem trf, @RequestBody int destination)
    {
        System.out.println("Attempting to send vehicle " + amb.getLicensePlate());

        if (ambulanceService.detectAmbulance(amb))
        {
            System.out.println("The sound associated with the vehicle confirms it is an ambulance. It is on its way!");
            trf.DFS(0,destination);
            List<Integer> route = trf.getRoute();
            double time = route.size() / 2.0;
            return ResponseEntity.ok("The ambulance "+amb.getLicensePlate()+" took the route " +route+ "and arrived in "+time+" minute" );
        }
        else
        {
            System.out.println("No ambulance detected. Try with another vehicle!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ambulance detected. Try with another vehicle!");
        }
    }
}
