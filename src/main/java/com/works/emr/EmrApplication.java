package com.works.emr;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;
import com.works.emr.patient.PatientEntity;
import com.works.emr.patient.PatientRepository;


@SpringBootApplication
public class EmrApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmrApplication.class, args);
	}


    @Bean
    CommandLineRunner createDemoDataIfNeeded(PatientRepository patientRepository) {
        return args -> {
				Faker faker = new Faker();
				//populate patient db with 99 records if none exists
				if (patientRepository.count() == 0) {
					System.out.println("Populating fake data...");
					for (int i = 0; i < 100; ++i) {
						System.out.println("Populating with fake data..." + i);
						patientRepository.save(
							new PatientEntity(
								null,
								faker.name().fullName(),
								faker.number().numberBetween(0, 90),
								faker.date().birthday()
						));
					}
					System.out.println("Population complete...");
				}
        };
    }
}

