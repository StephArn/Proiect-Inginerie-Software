package com.example.proiectIOT.repository;

import com.example.proiectIOT.model.Ambulance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AmbulanceRepository
        extends MongoRepository<Ambulance, String> {
    Optional<Ambulance> findAmbulanceByLicensePlate(String plate);


}
