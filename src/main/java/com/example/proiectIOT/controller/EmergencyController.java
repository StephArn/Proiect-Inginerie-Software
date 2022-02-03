package com.example.proiectIOT.controller;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.model.TrafficLightSystem;
import com.example.proiectIOT.service.AmbulanceService;
import com.example.proiectIOT.service.TrafficLightSystemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/emergency")
@AllArgsConstructor
public class EmergencyController {

    private final AmbulanceService ambulanceService;
    private final TrafficLightSystemService trafficLightSystemService;

    @PostMapping("/{destination}")
    public ResponseEntity handleEmergency(@RequestBody Ambulance amb, @PathVariable int destination)//, @RequestBody int destination)
    {
        TrafficLightSystem trf = new TrafficLightSystem(13);
        trf.addEdge(0, 1);
        trf.addEdge(1, 2);
        trf.addEdge(1, 5);
        trf.addEdge(1, 6);
        trf.addEdge(2, 3);
        trf.addEdge(2, 4);
        trf.addEdge(2, 6);
        trf.addEdge(2, 12);
        trf.addEdge(3, 7);
        trf.addEdge(5, 8);
        trf.addEdge(6, 9);
        trf.addEdge(6, 11);
        trf.addEdge(8, 9);
        trf.addEdge(8, 10);

        //int destination = 5;

        System.out.println(trf);

        System.out.println("Attempting to send vehicle " + amb.getLicensePlate());



        if (ambulanceService.detectAmbulance(amb))
        {
            System.out.println("The sound associated with the vehicle confirms it is an ambulance. It is on its way!");
            //trf.DFS(0,destination);
            //List<Integer> route = trf.getRoute();
            List<Integer> route = trf.DFS();

            double time = route.size() * 2;
            return ResponseEntity.ok("The ambulance "+amb.getLicensePlate()+" took the route " +route+ " and arrived in "+time+" minute. Traffic Lights were switched in the according intersections and now have been restored." );
        }
        else
        {
            System.out.println("No ambulance detected. Try with another vehicle!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ambulance detected. Try with another vehicle!");
        }
    }
}
