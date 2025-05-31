package com.example.sms.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.sms.dto.StudentDTO;
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

    public StudentDTO saveStudent(Student newStudent) {
        var savedStudent = repository.save(newStudent);

        var studentDTO = new StudentDTO();
        BeanUtils.copyProperties(savedStudent, studentDTO);

        return studentDTO;
    }

    public void deleteStudentById(String id) {
        var existingStudent = getStudentById(id);
        repository.delete(existingStudent);
    }

    public Student updateStudentById(String studentId, Student student) {
        getStudentById(studentId);
        student.setStudentId(studentId);

        return repository.save(student);
    }
}
