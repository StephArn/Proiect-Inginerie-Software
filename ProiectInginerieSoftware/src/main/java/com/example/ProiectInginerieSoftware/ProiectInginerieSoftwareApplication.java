package com.example.ProiectInginerieSoftware;

import com.example.ProiectInginerieSoftware.model.Ambulance;
import com.example.ProiectInginerieSoftware.service.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.util.BsonUtils;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = AmbulanceRepository.class)
public class ProiectInginerieSoftwareApplication {

//	@Autowired
//	private AmbulanceRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(ProiectInginerieSoftwareApplication.class, args);
	}


//	@Bean
//	CommandLineRunner runner()
//	{
//		return args -> {
//			Ambulance ambulance = new Ambulance(
//					"SV34ABC",
//					false,
//					0,
//					0
//			);
//
//			repo.insert(ambulance);
//		};
//	}

}
