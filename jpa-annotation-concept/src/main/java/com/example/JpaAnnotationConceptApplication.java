package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaAnnotationConceptApplication {
	private final EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Employee employee = Employee.builder()
					.employeeName("Srikant Nayak")
					.employeeDescription("Talented Employee")
					.employeeStatus(EmployeeStatus.ACTIVE)
					.build();

			employeeRepository.save(employee);
		};

	}
}
