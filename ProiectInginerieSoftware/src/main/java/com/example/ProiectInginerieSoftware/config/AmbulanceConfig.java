package com.example.ProiectInginerieSoftware.config;

import com.example.ProiectInginerieSoftware.service.AmbulanceService;
import com.example.ProiectInginerieSoftware.service.AmbulanceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmbulanceConfig {

    @Bean
    public AmbulanceService ambulanceService(){
        return new AmbulanceServiceImpl();
    }
}
