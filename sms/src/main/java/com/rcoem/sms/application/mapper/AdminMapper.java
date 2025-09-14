package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.domain.entities.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDetails toDto(Admin admin) {
        return AdminDetails.builder()
                .adminId(admin.getAdminId())
                .username(admin.getUsername())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .phoneNumber(admin.getPhoneNumber())
                .department(admin.getDepartment())
                .role(admin.getRole())
                .isActive(admin.getIsActive())
                .createdDate(admin.getCreatedDate())
                .lastLoginDate(admin.getLastLoginDate())
                .build();
    }

    public Admin toEntity(AdminDetails adminDetails) {
        return Admin.builder()
                .adminId(adminDetails.getAdminId())
                .username(adminDetails.getUsername())
                .email(adminDetails.getEmail())
                .password(adminDetails.getPassword())
                .firstName(adminDetails.getFirstName())
                .lastName(adminDetails.getLastName())
                .phoneNumber(adminDetails.getPhoneNumber())
                .department(adminDetails.getDepartment())
                .role(adminDetails.getRole())
                .isActive(adminDetails.getIsActive())
                .createdDate(adminDetails.getCreatedDate())
                .lastLoginDate(adminDetails.getLastLoginDate())
                .build();
    }
}
