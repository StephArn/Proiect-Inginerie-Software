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

    @Override
    public Boolean detectAmbulance(Ambulance ambulance){
        boolean first = (0.08 <= ambulance.getMfcc1()) && (ambulance.getMfcc1() <= 0.13);
        boolean second = (-188.05 <= ambulance.getMfcc2()) && (ambulance.getMfcc2() <= -110.32);
        boolean third = (96.04 <= ambulance.getMfcc3()) && (ambulance.getMfcc3() <= 149.29);

        return first && second && third;
    }
}
