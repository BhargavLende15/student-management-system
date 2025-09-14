package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDetails {
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
