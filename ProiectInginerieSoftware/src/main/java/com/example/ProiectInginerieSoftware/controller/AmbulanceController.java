package com.example.ProiectInginerieSoftware.controller;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import com.example.ProiectInginerieSoftware.service.AmbulanceRepository;
import com.example.ProiectInginerieSoftware.service.AmbulanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ambulance")
public class AmbulanceController {


    private AmbulanceService ambulanceService;

    @PostMapping("/add")
    public ResponseEntity<Ambulance> addAmbulance(@RequestBody Ambulance ambulance){
        int id = Integer.parseInt(ambulance.getId());
        return new ResponseEntity<Ambulance>(ambulanceService.saveAmbulance(id, ambulance), HttpStatus.CREATED);
    }



}
