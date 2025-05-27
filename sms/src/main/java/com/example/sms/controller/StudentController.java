package com.example.sms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable String id) {
        return service.getStudentById(id);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student newStudent) {
        return service.saveStudent(newStudent);
    }
}
