package com.bms.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Logs system activity to a text file for auditing and debugging.
 */
public class AuditLogger {
    private static final String LOG_FILE = "audit_log.txt";

    // Write a log entry to file
    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String logEntry = "[" + LocalDateTime.now() + "] " + message + System.lineSeparator();
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("⚠️ Error writing audit log: " + e.getMessage());
        }
    }

    // Example use: AuditLogger.log("Admin login successful.");
}
