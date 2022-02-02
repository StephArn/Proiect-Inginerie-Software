package com.example.proiectIOT.service;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.repository.AmbulanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AmbulanceService {

    private final AmbulanceRepository ambulanceRepository;
    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }
    public void insertAmbulance(Ambulance ambulance) {
        System.out.println("Inserting ambulance " + ambulance);
        ambulanceRepository.insert(ambulance);
    }

    public void updateAmbulance(Ambulance ambulance) {
        Ambulance savedAmbulance = ambulanceRepository.findById(ambulance.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", ambulance.getId())));
        savedAmbulance.setLicensePlate(ambulance.getLicensePlate());
        savedAmbulance.setMfcc1(ambulance.getMfcc1());
        savedAmbulance.setMfcc2(ambulance.getMfcc2());
        savedAmbulance.setMfcc3(ambulance.getMfcc3());
    }

    public Object getAmbulance(String plate) {
        return ambulanceRepository.findAmbulanceByLicensePlate(plate)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", plate)));
    }

    public void deleteAmbulance(String id) {
        ambulanceRepository.deleteById(id);
    }
}
