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



	@Bean
	CommandLineRunner runner(AmbulanceRepository repository, MongoTemplate mongoTemplate){
		return args -> {

			String plate = "SV55QAE";
			Ambulance ambulance = new Ambulance(
					plate,
					false,
					0.10,
					-150.05,
					116.04
			);

			//usingMongoTemplateAndQuery(repository, mongoTemplate, plate, ambulance);

			repository.findAmbulanceByLicensePlate(plate)
					.ifPresentOrElse(s ->{
						System.out.println(s + " already exists");
					},()->{
						System.out.println("Inserting ambulance " + ambulance);
						repository.insert(ambulance);
					});
		};
	}

//	private void //usingMongoTemplateAndQuery(AmbulanceRepository repository, MongoTemplate mongoTemplate, String plate, Ambulance ambulance) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("licensePlate").is(plate));
//
//		List<Ambulance> ambulances = mongoTemplate.find(query, Ambulance.class);
//
//		if(ambulances.size() > 1){
//			throw new IllegalStateException(
//					"many ambulances with plate" + plate
//			);
//		}
//
//		if (ambulances.isEmpty()){
//			System.out.println("Inserting ambulance " + ambulance);
//			repository.insert(ambulance);
//		} else {
//			System.out.println(ambulance + " already exists");
//		}
//	}

}
