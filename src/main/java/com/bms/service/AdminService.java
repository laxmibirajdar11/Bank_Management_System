package com.bms.service;

import com.bms.dao.AdminDAO;
import com.bms.model.Admin;
import java.util.List;

public class AdminService {
    private AdminDAO adminDAO = new AdminDAO();

    // Register new admin
    public void registerAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

    // View all admins
    public List<Admin> viewAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    // Get admin by ID
    public Admin findAdmin(int id) {
        return adminDAO.getAdminById(id);
    }

    // Update admin
    public boolean updateAdmin(Admin admin) {
        return adminDAO.updateAdmin(admin);
    }

    // Remove admin
    public boolean deleteAdmin(int id) {
        return adminDAO.deleteAdmin(id);
    }
}
