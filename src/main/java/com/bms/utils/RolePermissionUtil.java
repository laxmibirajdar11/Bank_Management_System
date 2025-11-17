package com.bms.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Utility class to handle user roles and permissions.
 */
public class RolePermissionUtil {
    private static final Map<String, Set<String>> ROLE_PERMISSIONS = new HashMap<>();

    static {
        // Define permissions for each role
        Set<String> adminPerms = new HashSet<>();
        adminPerms.add("ADD_EMPLOYEE");
        adminPerms.add("VIEW_REPORTS");
        adminPerms.add("DELETE_EMPLOYEE");
        adminPerms.add("APPROVE_KYC");

        Set<String> employeePerms = new HashSet<>();
        employeePerms.add("VIEW_PROFILE");
        employeePerms.add("UPDATE_PROFILE");

        ROLE_PERMISSIONS.put("ADMIN", adminPerms);
        ROLE_PERMISSIONS.put("EMPLOYEE", employeePerms);
    }

    // Check if a role has permission
    public static boolean hasPermission(String role, String permission) {
        Set<String> perms = ROLE_PERMISSIONS.get(role.toUpperCase());
        return perms != null && perms.contains(permission);
    }

    // Example:
    // RolePermissionUtil.hasPermission("ADMIN", "VIEW_REPORTS");
}
