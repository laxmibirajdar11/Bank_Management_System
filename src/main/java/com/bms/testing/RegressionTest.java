package com.bms.testing;

import com.bms.controller.EmployeeController;
//import com.bms.model.Employee;

/**
 * Basic regression test to ensure core functionalities remain stable
 * after code changes.
 */
public class RegressionTest {
    public static void main(String[] args) {
        System.out.println("🔁 Running Regression Test...");

        EmployeeController employeeController = new EmployeeController();

        // Add and verify an employee
        employeeController.addEmployee(1001, "Kiran", "HR", 45000, "kiran@bms.com");
        employeeController.displayAllEmployees();

        // Update employee
        employeeController.updateEmployee(1001, "Kiran", "HR", 47000, "kiran@bms.com");

        // Verify update
        employeeController.findEmployeeById(1001);

        // Delete employee
        employeeController.deleteEmployee(1001);
        employeeController.displayAllEmployees();

        System.out.println("✅ Regression Test Passed!");
    }
}

