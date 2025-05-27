package com.example.sms.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
