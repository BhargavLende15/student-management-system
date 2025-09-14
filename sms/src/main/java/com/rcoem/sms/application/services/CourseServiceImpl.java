package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.mapper.CourseMapper;
import com.rcoem.sms.domain.entities.Course;
import com.rcoem.sms.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CourseDetails> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> courseMapper.toDto(course))
                .toList();
    }

    @Override
    public CourseDetails createCourse(CourseDetails courseDetails) {
        String courseId = "COURSE" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        courseDetails.setCourseId(courseId);
        Course insertedRecord = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(insertedRecord);
    }

    @Override
    public CourseDetails getCourseById(String courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.isPresent() ? courseMapper.toDto(course.get()) : null;
    }

    @Override
    public CourseDetails updateCourseById(CourseDetails courseDetails) {
        Optional<Course> existingCourse = courseRepository.findById(courseDetails.getCourseId());
        if (existingCourse.isPresent()) {
            Course updatedCourse = courseRepository.save(courseMapper.toEntity(courseDetails));
            return courseMapper.toDto(updatedCourse);
        }
        return null;
    }

    @Override
    public void deleteCourseById(String courseId) {
        courseRepository.deleteById(courseId);
    }
}

