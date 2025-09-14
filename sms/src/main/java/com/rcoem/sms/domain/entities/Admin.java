package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "admins")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    String adminId;
    String username;
    String email;
    String password;
    String firstName;
    String lastName;
    String phoneNumber;
    String department;
    String role;
    Boolean isActive;
    String createdDate;
    String lastLoginDate;
}
