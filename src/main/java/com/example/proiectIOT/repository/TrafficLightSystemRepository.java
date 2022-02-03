package com.example.proiectIOT.repository;

import com.example.proiectIOT.model.TrafficLightSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TrafficLightSystemRepository
        extends MongoRepository<TrafficLightSystem, String> {
    Optional<TrafficLightSystem> findTrafficLightSystemById(String id);
}
