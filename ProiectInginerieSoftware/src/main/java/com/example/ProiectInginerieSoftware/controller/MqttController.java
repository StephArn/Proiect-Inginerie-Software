package com.example.ProiectInginerieSoftware.controller;


import com.example.ProiectInginerieSoftware.mqtt.MqttGateway;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttController {

    @Autowired
    MqttGateway mqttGateway;


    @PostMapping("/sendMessage")
    public ResponseEntity<?> publish(@RequestBody String message){
        try{
        JsonObject convertObject = new Gson().fromJson(message, JsonObject.class);
        mqttGateway.sendToMqtt(convertObject.get("message").toString(), convertObject.get("topic").toString());
        return ResponseEntity.ok("Success");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("Fail");
        }

    }

}
