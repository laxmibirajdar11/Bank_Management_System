package com.bms.dao;

import com.bms.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private List<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("✅ Employee added: " + employee.getName());
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.getEmployeeId() == id) {
                return e;
            }
        }
        return null;
    }

    // Update employee details
    public boolean updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == updatedEmployee.getEmployeeId()) {
                employees.set(i, updatedEmployee);
                System.out.println("🛠 Employee updated: " + updatedEmployee.getName());
                return true;
            }
        }
        return false;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getEmployeeId() == id);
    }
}
