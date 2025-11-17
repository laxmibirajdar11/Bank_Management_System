package com.bms.dao;

import com.bms.model.Admin;
import com.bms.utils.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    // ✅ Add a new admin to MySQL
    public void addAdmin(Admin admin) {
        String sql = "INSERT INTO admin (admin_id, name, email, password) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, admin.getAdminId());
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getPassword());
            ps.executeUpdate();

            System.out.println("✅ Admin added successfully to MySQL!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Fetch all admins from MySQL
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admin";

        try (Connection con = DBConnectionUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Admin a = new Admin(
                        rs.getInt("admin_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                admins.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
    // ✅ Find admin by ID
public Admin getAdminById(int id) {
    String sql = "SELECT * FROM admin WHERE admin_id = ?";
    Admin admin = null;

    try (Connection con = DBConnectionUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                admin = new Admin(
                    rs.getInt("admin_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return admin;
}

// ✅ Update admin details
public boolean updateAdmin(Admin updatedAdmin) {
    String sql = "UPDATE admin SET name = ?, email = ?, password = ? WHERE admin_id = ?";
    try (Connection con = DBConnectionUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, updatedAdmin.getName());
        ps.setString(2, updatedAdmin.getEmail());
        ps.setString(3, updatedAdmin.getPassword());
        ps.setInt(4, updatedAdmin.getAdminId());
        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

// ✅ Delete admin by ID
public boolean deleteAdmin(int id) {
    String sql = "DELETE FROM admin WHERE admin_id = ?";
    try (Connection con = DBConnectionUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

}
