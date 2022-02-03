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

    public Boolean detectAmbulance(Ambulance amb1)
    {
        double mfcc1 = amb1.getMfcc1();
        double mfcc2 = amb1.getMfcc2();
        double mfcc3 = amb1.getMfcc3();

        boolean first = (0.08 <= mfcc1) && (mfcc1 <= 0.13);
        boolean second = (-188.05 <= mfcc2) && (mfcc2 <= -110.32);
        boolean third = (96.04 <= mfcc3) && (mfcc3 <= 149.29);

        return first && second && third;
    }

    public List<Ambulance> getAllAmbulances() {
        return ambulanceRepository.findAll();
    }
    public void insertAmbulance(Ambulance ambulance) {
        System.out.println("Inserting ambulance " + ambulance);
        ambulanceRepository.insert(ambulance);
    }

    public void updateAmbulance(Ambulance ambulance) {
        Ambulance savedAmbulance = ambulanceRepository.findById(ambulance.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Ambulance by ID %s", ambulance.getId())));
        savedAmbulance.setLicensePlate(ambulance.getLicensePlate());
        savedAmbulance.setMfcc1(ambulance.getMfcc1());
        savedAmbulance.setMfcc2(ambulance.getMfcc2());
        savedAmbulance.setMfcc3(ambulance.getMfcc3());
    }

    public Object getAmbulance(String plate) {
        return ambulanceRepository.findAmbulanceByLicensePlate(plate)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Ambulance with License Plate - %s", plate)));
    }

    public void deleteAmbulance(String id) {
        ambulanceRepository.deleteById(id);
    }
}
