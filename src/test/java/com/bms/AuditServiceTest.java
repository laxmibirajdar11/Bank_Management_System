package com.bms;

import com.bms.model.AuditLog;
import com.bms.service.AuditService;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class AuditServiceTest {
    @Test
    public void testRecordLog() {
        AuditService service = new AuditService();
        AuditLog log = new AuditLog(1, 101, "Login successful", LocalDateTime.now(), "SUCCESS");

        service.recordAction(log);

        assertEquals(1, service.getAllLogs().size());
    }
}
