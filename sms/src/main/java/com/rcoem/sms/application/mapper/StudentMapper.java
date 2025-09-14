package com.rcoem.sms.application.mapper;


import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.domain.entities.StudentInfo;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDetails toDto(StudentInfo studentInfo){
        return StudentDetails.builder()
                .id(studentInfo.getId())
                .rollNo(studentInfo.getRollNo())
                .name(studentInfo.getName())
                .email(studentInfo.getEmail())
                .mobileNumber(studentInfo.getMobileNumber())
                .department(studentInfo.getDepartment())
                .gender(studentInfo.getGender())
                .course(studentInfo.getCourse())
                .dateOfBirth(studentInfo.getDateOfBirth())
                .address(studentInfo.getAddress())
                .build();
    }
    public  StudentInfo toEntity(StudentDetails studentDetails) {
        return StudentInfo.builder()
                .id(studentDetails.getId())
                .rollNo(studentDetails.getRollNo())
                .name(studentDetails.getName())
                .email(studentDetails.getEmail())
                .mobileNumber(studentDetails.getMobileNumber())
                .department(studentDetails.getDepartment())
                .gender(studentDetails.getGender())
                .course(studentDetails.getCourse())
                .dateOfBirth(studentDetails.getDateOfBirth())
                .address(studentDetails.getAddress())
                .build();
    }
}