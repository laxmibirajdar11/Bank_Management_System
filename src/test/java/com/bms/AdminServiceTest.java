package com.bms;

import com.bms.model.Admin;
import com.bms.service.AdminService;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminServiceTest {
    @Test
    public void testAddAdmin() {
        AdminService service = new AdminService();
        Admin admin = new Admin(1, "Niharika", "niharika@bms.com", "admin123");

        service.registerAdmin(admin);

        Admin result = service.findAdmin(1);
        assertNotNull("Admin should be added successfully", result);
        assertEquals("Niharika", result.getName());
    }
}
