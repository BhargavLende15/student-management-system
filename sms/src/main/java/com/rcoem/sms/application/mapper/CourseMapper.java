package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.domain.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDetails toDto(Course course) {
        return CourseDetails.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseCode(course.getCourseCode())
                .description(course.getDescription())
                .credits(course.getCredits())
                .department(course.getDepartment())
                .semester(course.getSemester())
                .academicYear(course.getAcademicYear())
                .isActive(course.getIsActive())
                .build();
    }

    public Course toEntity(CourseDetails courseDetails) {
        return Course.builder()
                .courseId(courseDetails.getCourseId())
                .courseName(courseDetails.getCourseName())
                .courseCode(courseDetails.getCourseCode())
                .description(courseDetails.getDescription())
                .credits(courseDetails.getCredits())
                .department(courseDetails.getDepartment())
                .semester(courseDetails.getSemester())
                .academicYear(courseDetails.getAcademicYear())
                .isActive(courseDetails.getIsActive())
                .build();
    }
}

