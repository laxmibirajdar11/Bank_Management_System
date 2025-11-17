package com.bms.controller;

import com.bms.model.AuditLog;
import com.bms.service.AuditService;
import java.time.LocalDateTime;
import java.util.List;

public class AuditController {
    private AuditService auditService = new AuditService();

    // Record a log
    public void recordLog(int logId, int userId, String action, String status) {
        AuditLog log = new AuditLog(logId, userId, action, LocalDateTime.now(), status);
        auditService.recordAction(log);
    }

    // View all logs
    public void displayAllLogs() {
        List<AuditLog> logs = auditService.getAllLogs();
        logs.forEach(System.out::println);
    }

    // View logs by user
    public void displayLogsByUser(int userId) {
        List<AuditLog> logs = auditService.getLogsByUser(userId);
        logs.forEach(System.out::println);
    }

    // Delete log
    public void deleteLog(int logId) {
        boolean deleted = auditService.deleteLog(logId);
        System.out.println(deleted ? "🗑 Log deleted." : "⚠️ Log not found.");
    }
}
