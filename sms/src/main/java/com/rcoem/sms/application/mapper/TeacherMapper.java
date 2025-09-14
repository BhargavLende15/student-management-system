package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.domain.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDetails toDto(Teacher teacher) {
        return TeacherDetails.builder()
                .teacherId(teacher.getTeacherId())
                .employeeId(teacher.getEmployeeId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .phoneNumber(teacher.getPhoneNumber())
                .department(teacher.getDepartment())
                .designation(teacher.getDesignation())
                .qualification(teacher.getQualification())
                .specialization(teacher.getSpecialization())
                .experience(teacher.getExperience())
                .joiningDate(teacher.getJoiningDate())
                .dateOfBirth(teacher.getDateOfBirth())
                .address(teacher.getAddress())
                .gender(teacher.getGender())
                .isActive(teacher.getIsActive())
                .createdDate(teacher.getCreatedDate())
                .build();
    }

    public Teacher toEntity(TeacherDetails teacherDetails) {
        return Teacher.builder()
                .teacherId(teacherDetails.getTeacherId())
                .employeeId(teacherDetails.getEmployeeId())
                .firstName(teacherDetails.getFirstName())
                .lastName(teacherDetails.getLastName())
                .email(teacherDetails.getEmail())
                .phoneNumber(teacherDetails.getPhoneNumber())
                .department(teacherDetails.getDepartment())
                .designation(teacherDetails.getDesignation())
                .qualification(teacherDetails.getQualification())
                .specialization(teacherDetails.getSpecialization())
                .experience(teacherDetails.getExperience())
                .joiningDate(teacherDetails.getJoiningDate())
                .dateOfBirth(teacherDetails.getDateOfBirth())
                .address(teacherDetails.getAddress())
                .gender(teacherDetails.getGender())
                .isActive(teacherDetails.getIsActive())
                .createdDate(teacherDetails.getCreatedDate())
                .build();
    }
}
