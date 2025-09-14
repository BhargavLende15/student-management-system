package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.mapper.AdminMapper;
import com.rcoem.sms.domain.entities.Admin;
import com.rcoem.sms.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<AdminDetails> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(admin -> adminMapper.toDto(admin))
                .toList();
    }

    @Override
    public AdminDetails createAdmin(AdminDetails adminDetails) {
        String adminId = "ADMIN" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        adminDetails.setAdminId(adminId);
        adminDetails.setCreatedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        adminDetails.setIsActive(true);
        
        Admin insertedRecord = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(insertedRecord);
    }

    @Override
    public AdminDetails getAdminById(String adminId) {
        Optional<Admin> admin = adminRepository.findById(adminId);
        return admin.isPresent() ? adminMapper.toDto(admin.get()) : null;
    }

    @Override
    public AdminDetails updateAdminById(AdminDetails adminDetails) {
        Optional<Admin> existingAdmin = adminRepository.findById(adminDetails.getAdminId());
        if (existingAdmin.isPresent()) {
            Admin updatedAdmin = adminRepository.save(adminMapper.toEntity(adminDetails));
            return adminMapper.toDto(updatedAdmin);
        }
        return null;
    }

    @Override
    public void deleteAdminById(String adminId) {
        adminRepository.deleteById(adminId);
    }
}
