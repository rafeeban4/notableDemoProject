package com.example.notable;

import com.example.notable.db.AppointmentRepository;
import com.example.notable.db.DoctorRepository;
import com.example.notable.model.Appointment;
import com.example.notable.model.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotableApplication {
	private static final Logger log = LoggerFactory.getLogger(NotableApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NotableApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
		return (args) -> {
			// save a few customers
			doctorRepository.save(new Doctor("Jack", "Bauer"));
			doctorRepository.save(new Doctor("Chloe", "O'Brian"));

			appointmentRepository.save(new Appointment("firstName", "lastName",  "01/01/2020", "5:15",  1L,true ));

		};
	}

}
