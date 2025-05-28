package com.example.sms.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.exception.StudentNotFoundException;
import com.example.sms.respository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(String id) {
        var existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id :- " + id));

        return existingStudent;
    }

    public Student saveStudent(Student newStudent) {
        return repository.save(newStudent);
    }
}
