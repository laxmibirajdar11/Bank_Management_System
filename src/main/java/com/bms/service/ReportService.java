package com.bms.service;

import com.bms.dao.ReportDAO;
import com.bms.model.Report;
import java.util.List;

public class ReportService {
    private ReportDAO reportDAO = new ReportDAO();

    // Generate new report
    public void generateReport(Report report) {
        reportDAO.addReport(report);
    }

    // View all reports
    public List<Report> viewAllReports() {
        return reportDAO.getAllReports();
    }

    // View single report
    public Report getReportById(int id) {
        return reportDAO.getReportById(id);
    }

    // Update report
    public boolean updateReport(Report report) {
        return reportDAO.updateReport(report);
    }

    // Delete report
    public boolean deleteReport(int id) {
        return reportDAO.deleteReport(id);
    }
}
