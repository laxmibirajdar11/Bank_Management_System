package com.bms.controller;

import com.bms.model.Admin;
import com.bms.service.AdminService;
import java.util.List;

public class AdminController {
    private AdminService adminService = new AdminService();

    // Add new admin
    public void createAdmin(int id, String name, String email, String password) {
        Admin admin = new Admin(id, name, email, password);
        adminService.registerAdmin(admin);
    }

    // View all admins
    public void displayAllAdmins() {
        List<Admin> admins = adminService.viewAllAdmins();
        admins.forEach(System.out::println);
    }

    // Find admin
    public void findAdminById(int id) {
        Admin admin = adminService.findAdmin(id);
        if (admin != null) {
            System.out.println("🔍 Found Admin: " + admin);
        } else {
            System.out.println("❌ Admin not found with ID: " + id);
        }
    }

    // Update admin
    public void updateAdmin(int id, String name, String email, String password) {
        Admin admin = new Admin(id, name, email, password);
        boolean updated = adminService.updateAdmin(admin);
        System.out.println(updated ? "✅ Admin updated." : "⚠️ Update failed.");
    }

    // Delete admin
    public void deleteAdmin(int id) {
        boolean deleted = adminService.deleteAdmin(id);
        System.out.println(deleted ? "🗑 Admin deleted." : "⚠️ Admin not found.");
    }
}
