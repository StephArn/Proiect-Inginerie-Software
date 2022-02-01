package com.example.ProiectInginerieSoftware.service;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AmbulanceService {
    Ambulance saveAmbulance(int id, Ambulance ambulance);
}
