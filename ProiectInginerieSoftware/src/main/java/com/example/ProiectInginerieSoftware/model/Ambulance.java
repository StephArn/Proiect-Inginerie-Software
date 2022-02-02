package com.example.ProiectInginerieSoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Ambulance {
    @Id
    String id;

    @Field
    @Indexed(unique = true)
    String licensePlate;

    @Field
    boolean sensorStatus;

    @Field
    int posx, posy;

    @Field
    double mfcc1, mfcc2, mfcc3;

    public Ambulance(String licensePlate, boolean sensorStatus, int posx, int posy) {
        this.licensePlate = licensePlate;
        this.sensorStatus = sensorStatus;
        this.posx = posx;
        this.posy = posy;
    }
}
