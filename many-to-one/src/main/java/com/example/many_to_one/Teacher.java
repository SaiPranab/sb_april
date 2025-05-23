package com.example.many_to_one;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String teacherId;

    private String teacherName;
    private String teacherEmail;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER) // mapped by can only be present in the inverse side
    private List<Course> courses;
}
