package com.example.proiectIOT.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ambulance {

    @Id
    private String id;

    @Indexed(unique = true)
    private String licensePlate;

    private boolean sensorStatus;
    private double mfcc1;
    private double mfcc2;
    private double mfcc3;

    public Ambulance(String licensePlate, boolean sensorStatus, double mfcc1, double mfcc2, double mfcc3) {
        this.licensePlate = licensePlate;
        this.sensorStatus = sensorStatus;
        this.mfcc1 = mfcc1;
        this.mfcc2 = mfcc2;
        this.mfcc3 = mfcc3;
    }
}
