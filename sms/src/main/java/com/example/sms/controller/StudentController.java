package com.example.sms.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.dto.StudentDTO;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return service.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student newStudent = new Student();
        BeanUtils.copyProperties(studentDTO, newStudent);

        return service.saveStudent(newStudent);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        service.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return service.updateStudentById(id, student);
    }
}
