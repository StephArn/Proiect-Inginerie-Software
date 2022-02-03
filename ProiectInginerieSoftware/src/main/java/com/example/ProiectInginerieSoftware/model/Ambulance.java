package com.example.ProiectInginerieSoftware.model;

public class Ambulance {

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