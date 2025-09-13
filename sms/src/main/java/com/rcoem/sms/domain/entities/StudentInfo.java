package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "student_info")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {
    @Id
    String rollNo; //roll_no
    String id;
    String name;
    String course;
    String email;
    String mobileNumber; //mobile_Number
    String department;
    String gender;
    String dateOfBirth;
    String address;
}


