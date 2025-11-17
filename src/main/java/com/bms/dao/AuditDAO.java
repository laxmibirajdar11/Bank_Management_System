package com.bms.dao;

import com.bms.model.AuditLog;
import java.util.ArrayList;
import java.util.List;

public class AuditDAO {
    private List<AuditLog> auditLogs = new ArrayList<>();

    // Add new audit log
    public void addLog(AuditLog log) {
        auditLogs.add(log);
        System.out.println("📝 Audit log recorded: " + log.getAction());
    }

    // Get all logs
    public List<AuditLog> getAllLogs() {
        return auditLogs;
    }

    // Get logs by user ID
    public List<AuditLog> getLogsByUserId(int userId) {
        List<AuditLog> userLogs = new ArrayList<>();
        for (AuditLog log : auditLogs) {
            if (log.getUserId() == userId) {
                userLogs.add(log);
            }
        }
        return userLogs;
    }

    // Delete a log by ID
    public boolean deleteLog(int logId) {
        return auditLogs.removeIf(log -> log.getLogId() == logId);
    }
}
