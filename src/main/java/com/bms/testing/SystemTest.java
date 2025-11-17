package com.bms.testing;

import com.bms.controller.*;
//import com.bms.model.*;

public class SystemTest {
    public static void main(String[] args) {
        System.out.println("🧪 Starting System Test...");

        // Initialize controllers
        AdminController adminController = new AdminController();
        EmployeeController employeeController = new EmployeeController();
        AuditController auditController = new AuditController();
        ReportController reportController = new ReportController();

        // --- Admin Operations ---
        adminController.createAdmin(1, "Niharika", "niharika@bms.com", "admin123");
        adminController.createAdmin(2, "Pallavi", "pallavi@bms.com", "admin456");
        adminController.displayAllAdmins();

        // --- Employee Operations ---
        employeeController.addEmployee(1, "Rahul", "Finance", 50000, "rahul@bms.com");
        employeeController.addEmployee(2, "Ananya", "IT", 60000, "ananya@bms.com");
        employeeController.displayAllEmployees();

        // --- Audit Log Operations ---
        auditController.recordLog(1, 1, "Admin login successful", "SUCCESS");
        auditController.recordLog(2, 2, "Report viewed", "SUCCESS");
        auditController.displayAllLogs();

        // --- Report Operations ---
        reportController.createReport(101, "Monthly Finance", "Niharika", "Generated finance summary");
        reportController.createReport(102, "Employee Overview", "Pallavi", "All employee performance data");
        reportController.displayAllReports();

        System.out.println("\n✅ System Test Completed Successfully!");
    }
}

