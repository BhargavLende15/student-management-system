package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "teachers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
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
