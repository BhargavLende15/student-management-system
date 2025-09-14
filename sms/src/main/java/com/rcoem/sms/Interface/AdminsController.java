package com.rcoem.sms.Interface;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    
    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseEntity<Object> addAdmin(@RequestBody AdminDetails adminDetails) {
        AdminDetails insertedAdminDetails = adminService.createAdmin(adminDetails);
        return ResponseEntity.created(URI.create("/admins/" + insertedAdminDetails.getAdminId())).build();
    }

    @GetMapping
    public List<AdminDetails> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDetails> getAdminById(@PathVariable String adminId) {
        AdminDetails adminDetails = adminService.getAdminById(adminId);
        if (adminDetails != null) {
            return ResponseEntity.ok(adminDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminDetails> updateAdmin(@PathVariable String adminId, @RequestBody AdminDetails adminDetails) {
        adminDetails.setAdminId(adminId);
        AdminDetails updatedAdmin = adminService.updateAdminById(adminDetails);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String adminId) {
        adminService.deleteAdminById(adminId);
        return ResponseEntity.noContent().build();
    }
}
