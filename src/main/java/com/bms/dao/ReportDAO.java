package com.bms.dao;

import com.bms.model.Report;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    private List<Report> reports = new ArrayList<>();

    // Add new report
    public void addReport(Report report) {
        reports.add(report);
        System.out.println("📊 Report added: " + report.getReportType());
    }

    // Get all reports
    public List<Report> getAllReports() {
        return reports;
    }

    // Get report by ID
    public Report getReportById(int id) {
        for (Report r : reports) {
            if (r.getReportId() == id) {
                return r;
            }
        }
        return null;
    }

    // Update report
    public boolean updateReport(Report updatedReport) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).getReportId() == updatedReport.getReportId()) {
                reports.set(i, updatedReport);
                System.out.println("🛠 Report updated: " + updatedReport.getReportType());
                return true;
            }
        }
        return false;
    }

    // Delete report
    public boolean deleteReport(int id) {
        return reports.removeIf(r -> r.getReportId() == id);
    }
}
