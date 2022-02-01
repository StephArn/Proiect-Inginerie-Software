package com.example.ProiectInginerieSoftware.service;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AmbulanceRepository extends MongoRepository<Ambulance, String> {
    Optional<Ambulance> findAmbulanceById(int id);

}
