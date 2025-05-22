package com.example.one_to_one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {
	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return ss -> {
			Student student = Student.builder()
					.studentName("Sai")
					.studentEmail("s@gmail.com")
					.build();

			Address address = Address.builder()
					.city("Bhubaneswar")
					.state("Odisha")
					.country("IN")
					.build();

			student.setAddress(address);
			// studentRepository.save(student);

			// Student existingStudent = studentRepository.findById(1).orElseThrow();
			// existingStudent.setStudentName("Sai Pranab patra");
			// existingStudent.getAddress().setCity("Cuttack");
			// studentRepository.save(existingStudent);

			// studentRepository.delete(existingStudent);

			// RETRIEVE
			// System.out.println("See the student details");
			// Student existingStudent = studentRepository.findById(2).orElseThrow();
			// System.out.println(existingStudent.getStudentRoll());
			// System.out.println(existingStudent.getStudentName());
			// System.out.println(existingStudent.getStudentEmail());

			// Address existingStudentAddress = existingStudent.getAddress();
			// System.out.println(existingStudentAddress.getCity());
			// System.out.println(existingStudentAddress.getCountry());
			// System.out.println(existingStudentAddress.getState());

			// RETREVE STUDENT FROM ADDRESS
			// Address existingAddress = addressRepository
			// .findById("230edf7e-3b9f-4006-849c-08f76bd385d1").orElseThrow();
			// Student existingAddressStudent = existingAddress.getStudent();
			// System.out.println(existingAddressStudent.getStudentRoll());
			// System.out.println(existingAddressStudent.getStudentName());
			// System.out.println(existingAddressStudent.getStudentEmail());

			Student student2 = Student.builder()
					.studentName("Sipun")
					.studentEmail("sipun@gmail.com")
					.build();

			Address address2 = Address.builder()
					.city("Kendrapara")
					.state("OD")
					.country("IN")
					.student(student2)
					.build();

			student2.setAddress(address2);
			studentRepository.save(student2);
			// addressRepository.save(address2);
		};
	}
}
