package com.rcoem.sms.Interface;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<Object> addCourse(@RequestBody CourseDetails courseDetails) {
        CourseDetails insertedCourseDetails = courseService.createCourse(courseDetails);
        return ResponseEntity.created(URI.create("/courses/" + insertedCourseDetails.getCourseId())).build();
    }

    @GetMapping
    public List<CourseDetails> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDetails> getCourseById(@PathVariable String courseId) {
        CourseDetails courseDetails = courseService.getCourseById(courseId);
        if (courseDetails != null) {
            return ResponseEntity.ok(courseDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseDetails> updateCourse(@PathVariable String courseId, @RequestBody CourseDetails courseDetails) {
        courseDetails.setCourseId(courseId);
        CourseDetails updatedCourse = courseService.updateCourseById(courseDetails);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
}

