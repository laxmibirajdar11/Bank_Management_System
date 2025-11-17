package com.bms;

import com.bms.model.Report;
import com.bms.service.ReportService;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class ReportServiceTest {
    @Test
    public void testGenerateReport() {
        ReportService service = new ReportService();
        Report report = new Report(501, "Monthly Report", "Admin", LocalDate.now(), "Finance summary");

        service.generateReport(report);

        Report fetched = service.getReportById(501);
        assertNotNull("Report should exist", fetched);
        assertEquals("Monthly Report", fetched.getReportType());
    }
}
