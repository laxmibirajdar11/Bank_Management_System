package com.bms;

import com.bms.model.Employee;
import com.bms.service.EmployeeService;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeServiceTest {
    @Test
    public void testAddEmployee() {
        EmployeeService service = new EmployeeService();
        Employee emp = new Employee(101, "Rahul", "Finance", 55000, "rahul@bms.com");

        service.addEmployee(emp);

        Employee result = service.findEmployee(101);
        assertNotNull("Employee should be added", result);
        assertEquals("Rahul", result.getName());
    }
}
