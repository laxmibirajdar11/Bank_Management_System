package com.bms.service;

import com.bms.dao.AuditDAO;
import com.bms.model.AuditLog;
import java.util.List;

public class AuditService {
    private AuditDAO auditDAO = new AuditDAO();

    // Record audit action
    public void recordAction(AuditLog log) {
        auditDAO.addLog(log);
    }

    // Get all logs
    public List<AuditLog> getAllLogs() {
        return auditDAO.getAllLogs();
    }

    // Get logs by user
    public List<AuditLog> getLogsByUser(int userId) {
        return auditDAO.getLogsByUserId(userId);
    }

    // Delete a specific log
    public boolean deleteLog(int logId) {
        return auditDAO.deleteLog(logId);
    }
}
