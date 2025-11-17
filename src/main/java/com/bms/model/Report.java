package com.bms.model;

import java.time.LocalDate;

public class Report {
    private int reportId;
    private String reportType;
    private String generatedBy;
    private LocalDate generatedDate;
    private String description;

    // Constructor
    public Report(int reportId, String reportType, String generatedBy, LocalDate generatedDate, String description) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.generatedBy = generatedBy;
        this.generatedDate = generatedDate;
        this.description = description;
    }

    // Default constructor
    public Report() {
        this.generatedDate = LocalDate.now();
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDate generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ToString for debugging
    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportType='" + reportType + '\'' +
                ", generatedBy='" + generatedBy + '\'' +
                ", generatedDate=" + generatedDate +
                ", description='" + description + '\'' +
                '}';
    }
}
