package com.bms.service;

import com.bms.dao.EmployeeDAO;
import com.bms.model.Employee;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    // Add employee
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    // Get all employees
    public List<Employee> viewAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    // Get by ID
    public Employee findEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    // Update
    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    // Delete
    public boolean removeEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
