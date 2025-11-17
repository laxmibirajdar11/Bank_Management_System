package com.bms.web;

import com.bms.model.Admin;
import com.bms.service.AdminService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

    private final AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Admin> admins = adminService.viewAllAdmins();

        resp.setContentType("text/html");
        StringBuilder html = new StringBuilder();

        html.append("<html><head><title>Admin Dashboard</title>")
            .append("<style>")
            .append("body {font-family: Arial; background:#f0f3f5;}")
            .append("h1 {text-align:center; color:#0047ab;}")
            .append("table {border-collapse: collapse; width:70%; margin:auto;}")
            .append("th, td {padding:10px; border:1px solid #ccc; text-align:center;}")
            .append("th {background:#0047ab; color:white;}")
            .append("</style></head><body>");

        html.append("<h1>Admin Dashboard</h1>");
        html.append("<table>");
        html.append("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

        for (Admin a : admins) {
            html.append("<tr>")
                .append("<td>").append(a.getAdminId()).append("</td>")
                .append("<td>").append(a.getName()).append("</td>")
                .append("<td>").append(a.getEmail()).append("</td>")
                .append("</tr>");
        }

        html.append("</table></body></html>");
        resp.getWriter().write(html.toString());
    }
}
