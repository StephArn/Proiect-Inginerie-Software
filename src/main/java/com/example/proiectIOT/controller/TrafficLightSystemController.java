package com.example.proiectIOT.controller;

import com.example.proiectIOT.model.TrafficLightSystem;
import com.example.proiectIOT.service.TrafficLightSystemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trafficlightsystems")
@AllArgsConstructor
public class TrafficLightSystemController {

    private final TrafficLightSystemService trafficLightSystemService;

    @GetMapping
    public List<TrafficLightSystem> fetchAllSystems(){
        return trafficLightSystemService.getAllSystems();
    }

    @PostMapping
    public ResponseEntity addSystem(@RequestBody TrafficLightSystem trafficLightSystem) {
        trafficLightSystemService.insertSystem(trafficLightSystem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateSystem(@RequestBody TrafficLightSystem trafficLightSystem) {
        trafficLightSystemService.updateSystem(trafficLightSystem);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getSystemByID(@PathVariable String id) {
        return ResponseEntity.ok(trafficLightSystemService.getSystem(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrafficSystem(@PathVariable String id) {
        trafficLightSystemService.deleteSystem(id);
        return ResponseEntity.noContent().build();
    }

}
