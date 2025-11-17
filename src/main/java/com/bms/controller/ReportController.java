package com.bms.controller;

import com.bms.model.Report;
import com.bms.service.ReportService;
import java.time.LocalDate;
import java.util.List;

public class ReportController {
    private ReportService reportService = new ReportService();

    // Generate a new report
    public void createReport(int id, String type, String generatedBy, String description) {
        Report report = new Report(id, type, generatedBy, LocalDate.now(), description);
        reportService.generateReport(report);
    }

    // View all reports
    public void displayAllReports() {
        List<Report> reports = reportService.viewAllReports();
        reports.forEach(System.out::println);
    }

    // Find report by ID
    public void findReportById(int id) {
        Report report = reportService.getReportById(id);
        System.out.println(report != null ? "📄 Found: " + report : "❌ Report not found.");
    }

    // Update report
    public void updateReport(int id, String type, String generatedBy, String description) {
        Report report = new Report(id, type, generatedBy, LocalDate.now(), description);
        boolean updated = reportService.updateReport(report);
        System.out.println(updated ? "✅ Report updated." : "⚠️ Update failed.");
    }

    // Delete report
    public void deleteReport(int id) {
        boolean deleted = reportService.deleteReport(id);
        System.out.println(deleted ? "🗑 Report deleted." : "⚠️ Report not found.");
    }
}
