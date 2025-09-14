package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "courses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    String courseId;
    String courseName;
    String courseCode;
    String description;
    Integer credits;
    String department;
    String semester;
    String academicYear;
    Boolean isActive;
}

