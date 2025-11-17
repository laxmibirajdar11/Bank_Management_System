package com.bms.controller;

import com.bms.model.Employee;
import com.bms.service.EmployeeService;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();

    // Add new employee
    public void addEmployee(int id, String name, String department, double salary, String email) {
        Employee emp = new Employee(id, name, department, salary, email);
        employeeService.addEmployee(emp);
    }

    // View all employees
    public void displayAllEmployees() {
        List<Employee> employees = employeeService.viewAllEmployees();
        employees.forEach(System.out::println);
    }

    // Find employee
    public void findEmployeeById(int id) {
        Employee emp = employeeService.findEmployee(id);
        System.out.println(emp != null ? "🔍 Found: " + emp : "❌ Employee not found.");
    }

    // Update employee
    public void updateEmployee(int id, String name, String department, double salary, String email) {
        Employee emp = new Employee(id, name, department, salary, email);
        boolean updated = employeeService.updateEmployee(emp);
        System.out.println(updated ? "✅ Employee updated." : "⚠️ Update failed.");
    }

    // Delete employee
    public void deleteEmployee(int id) {
        boolean deleted = employeeService.removeEmployee(id);
        System.out.println(deleted ? "🗑 Employee deleted." : "⚠️ Employee not found.");
    }
}
