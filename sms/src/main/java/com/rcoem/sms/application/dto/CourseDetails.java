package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDetails {
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

