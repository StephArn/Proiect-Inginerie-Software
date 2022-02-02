package com.example.proiectIOT.controller;

import com.example.proiectIOT.service.AmbulanceService;
import com.example.proiectIOT.model.Ambulance;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/ambulances")
@AllArgsConstructor
public class AmbulanceController {

    private final AmbulanceService ambulanceService;

    @GetMapping
    public List<Ambulance> fetchAllAmbulances(){
        return ambulanceService.getAllAmbulances();
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Ambulance ambulance) {
        ambulanceService.insertAmbulance(ambulance);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Ambulance ambulance) {
        ambulanceService.updateAmbulance(ambulance);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{plate}")
    public ResponseEntity getExpenseByName(@PathVariable String plate) {
        return ResponseEntity.ok(ambulanceService.getAmbulance(plate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        ambulanceService.deleteAmbulance(id);
        return ResponseEntity.noContent().build();
    }



    

    
}
