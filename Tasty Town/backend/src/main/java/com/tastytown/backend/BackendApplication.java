package com.tastytown.backend;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {
	@Value("${upload.file.dir}") // Spel
	private String FILE_DIR;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			var file = new File(FILE_DIR);
			if(! file.exists()) {
				file.mkdir();
				System.out.println("Folder created to store food images");
			}

			System.out.println("Folder already exists");
 		};
	}
}
