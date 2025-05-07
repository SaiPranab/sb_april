package com.example.miscellaneous_topics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiscellaneousTopicsApplication {
	private Animal animal;

	public MiscellaneousTopicsApplication(@Qualifier("dog") Animal animal) {
		this.animal = animal;
	}

	public static void main(String[] args) {
		SpringApplication.run(MiscellaneousTopicsApplication.class, args);
		// animal.eat();
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello from commandline runner");
			System.out.println("This method is executed just after the container is fully prepared");

			animal.eat();
		};
	}

}
/**
 * CommandLineRunner -> run
 * // preloading of data in the database
 * // to log some startup info
 * 
 * 
 * interface beans concept
 */
