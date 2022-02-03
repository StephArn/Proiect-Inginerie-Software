package com.example.proiectIOT;

import com.example.proiectIOT.model.Ambulance;
import com.example.proiectIOT.repository.AmbulanceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ProiectIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectIotApplication.class, args);
	}



//	@Bean
//	CommandLineRunner runner(AmbulanceRepository repository, MongoTemplate mongoTemplate){
//		return args -> {
//
//			String plate = "SV55QAE";
//			Ambulance ambulance = new Ambulance(
//					plate,
//					false,
//					0.10,
//					-150.05,
//					116.04
//			);

//			repository.findAmbulanceByLicensePlate(plate)
//					.ifPresentOrElse(s ->{
//						System.out.println(s + " already exists");
//					},()->{
//						System.out.println("Inserting ambulance " + ambulance);
//						repository.insert(ambulance);
//					});
//		};
//	}


}
