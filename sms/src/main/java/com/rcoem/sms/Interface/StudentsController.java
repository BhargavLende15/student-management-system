package com.rcoem.sms.Interface;

import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody StudentDetails studentDetails){
        StudentDetails insertedStudentDetails=studentService.createStudent(studentDetails);
        return ResponseEntity.created(URI.create("/students/"+insertedStudentDetails.getId())).build();
    }

    @GetMapping
    public List<StudentDetails> getStudents(){return studentService.getAllStudents();}

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetails> getStudentById(@PathVariable String id){
        StudentDetails studentDetails = studentService.getStudentById(id);
        if (studentDetails != null) {
            return ResponseEntity.ok(studentDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDetails> updateStudent(@PathVariable String id, @RequestBody StudentDetails studentDetails) {
        studentDetails.setId(id);
        StudentDetails updatedStudent = studentService.updateStudentById(studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(id);
        studentService.deleteStudentById(studentDetails);
        return ResponseEntity.noContent().build();
    }

}