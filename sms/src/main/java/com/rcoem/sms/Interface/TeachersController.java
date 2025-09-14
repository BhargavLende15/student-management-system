package com.rcoem.sms.Interface;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Object> addTeacher(@RequestBody TeacherDetails teacherDetails) {
        TeacherDetails insertedTeacherDetails = teacherService.createTeacher(teacherDetails);
        return ResponseEntity.created(URI.create("/teachers/" + insertedTeacherDetails.getTeacherId())).build();
    }

    @GetMapping
    public List<TeacherDetails> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDetails> getTeacherById(@PathVariable String teacherId) {
        TeacherDetails teacherDetails = teacherService.getTeacherById(teacherId);
        if (teacherDetails != null) {
            return ResponseEntity.ok(teacherDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDetails> updateTeacher(@PathVariable String teacherId, @RequestBody TeacherDetails teacherDetails) {
        teacherDetails.setTeacherId(teacherId);
        TeacherDetails updatedTeacher = teacherService.updateTeacherById(teacherDetails);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String teacherId) {
        teacherService.deleteTeacherById(teacherId);
        return ResponseEntity.noContent().build();
    }
}
