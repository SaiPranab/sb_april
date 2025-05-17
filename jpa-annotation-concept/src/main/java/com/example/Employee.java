package com.example;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Builder
@Table(name = "employees_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String employeeId;

    @Column(name = "emp_name", columnDefinition = "VARCHAR(30)", nullable = false)
    private String employeeName;

    @Lob // string - longtext, byte[] - BLOD, char[] - > CLOB
    @Column(columnDefinition = "MEDIUMTEXT")
    private String employeeDescription;

    @Transient
    private double employeeSalary;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
}
