package com.example.ProiectInginerieSoftware.service;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import org.springframework.stereotype.Service;

@Service
public class AmbulanceServiceImpl implements AmbulanceService{

    private AmbulanceRepository ambulanceRepository;

    public AmbulanceServiceImpl(AmbulanceRepository ambulanceRepository) {
        super();
        this.ambulanceRepository = ambulanceRepository;
    }

    public AmbulanceServiceImpl() {

    }

    @Override
    public Ambulance saveAmbulance(int id, Ambulance ambulance) {
        return ambulanceRepository.save(ambulance);
    }
}
