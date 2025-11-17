<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bms.model.Admin" %>

<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f0f3f5;
        }
        h1 {
            text-align: center;
            color: #0047ab;
        }
        table {
            border-collapse: collapse;
            width: 70%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #0047ab;
            color: white;
        }
    </style>
</head>
<body>

<h1>Admin Dashboard</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <% 
        List<Admin> admins = (List<Admin>) request.getAttribute("admins");
        if (admins != null) {
            for (Admin a : admins) {
    %>
    <tr>
        <td><%= a.getAdminId() %></td>
        <td><%= a.getName() %></td>
        <td><%= a.getEmail() %></td>
    </tr>
    <% 
            }
        }
    %>
</table>

</body>
</html>
