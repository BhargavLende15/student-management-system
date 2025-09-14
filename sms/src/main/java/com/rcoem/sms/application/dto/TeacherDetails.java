package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherDetails {
    String teacherId;
    String employeeId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String department;
    String designation;
    String qualification;
    String specialization;
    String experience;
    String joiningDate;
    String dateOfBirth;
    String address;
    String gender;
    Boolean isActive;
    String createdDate;
}
