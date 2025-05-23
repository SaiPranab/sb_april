package com.example.many_to_one;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication implements CommandLineRunner {
	private final CourseRepository courseRepository;
	private final TeacherRepository teacherRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Extract Course by Teacher
		Teacher existingTeacher = teacherRepository
				.findById("b76a6779-9414-45a4-a8d8-1ea1e04af3c2").orElseThrow();

		System.out.println("See the teacher details");
		System.out.println(existingTeacher.getTeacherName());
		System.out.println(existingTeacher.getTeacherEmail());

		List<Course> existingTeacherCourses = existingTeacher.getCourses();
		for (Course course : existingTeacherCourses) {
			System.out.println(course.getCourseName());
		}
	}

	public void uniDirectional() {
		Course course1 = Course.builder().courseName("C").build();
		Course course2 = Course.builder().courseName("C++").build();
		Course course3 = Course.builder().courseName("Java").build();
		Course course4 = Course.builder().courseName("Javascript").build();
		Course course5 = Course.builder().courseName("PHP").build();
		Course course6 = Course.builder().courseName(".NET").build();

		Teacher teacher1 = Teacher.builder().teacherName("Amiya")
				.teacherEmail("a@gmail.com").build();
		Teacher teacher2 = Teacher.builder().teacherName("Sai")
				.teacherEmail("s@gmail.com").build();
		Teacher teacher3 = Teacher.builder().teacherName("Priyanshu")
				.teacherEmail("p@gmail.com").build();

		course1.setTeacher(teacher1);
		course2.setTeacher(teacher1);
		course3.setTeacher(teacher2);
		course4.setTeacher(teacher2);
		course5.setTeacher(teacher3);
		course6.setTeacher(teacher3);

		// courseRepository.saveAll(List.of(course1, course2, course3, course4, course5,
		// course6));

		Course existingCourse = courseRepository.findById(1).orElseThrow();
		existingCourse.setCourseName("C1");
		existingCourse.getTeacher().setTeacherName("Amiya1");
		// courseRepository.save(existingCourse);

		// Extract -> Course (many-to-one) => EAGER
		System.out.println("See the course details");
		System.out.println(existingCourse.getCourseName());

		Teacher existingCourseTeacher = existingCourse.getTeacher();
		System.out.println(existingCourseTeacher.getTeacherName());
		System.out.println(existingCourseTeacher.getTeacherEmail());
	}

}
