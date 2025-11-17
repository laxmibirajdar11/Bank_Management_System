package com.bms.testing;

import com.bms.controller.ReportController;
import com.bms.model.Report;
import com.bms.utils.ReportFormatter;

/**
 * Test class for report generation and formatting.
 */
public class TestReportGenerator {
    public static void main(String[] args) {
        System.out.println("📊 Testing Report Generation and Formatting...");

        ReportController reportController = new ReportController();
        reportController.createReport(501, "Annual Summary", "Admin", "All financial and employee data.");

        // Simulate retrieving and formatting
        Report report = new Report(501, "Annual Summary", "Admin", java.time.LocalDate.now(), "All financial and employee data.");
        String formattedReport = ReportFormatter.formatReport(report);

        System.out.println(formattedReport);
        System.out.println("✅ Report Generation Test Completed!");
    }
}
