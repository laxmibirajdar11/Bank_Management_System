// Dummy Admin Data
const admins = [
    { adminId: 1, name: "Niharika", email: "niharika@bms.com" },
    { adminId: 2, name: "Pallavi", email: "pallavi@bms.com" }
];

// Dummy Employee Data
const employees = [
    { empId: 1, name: "Rahul", dept: "Finance", salary: 50000 },
    { empId: 2, name: "Ananya", dept: "IT", salary: 60000 }
];

// Load Admin Data
if (document.getElementById("adminTable")) {
    const body = document.querySelector("#adminTable tbody");

    admins.forEach(a => {
        const row = `<tr>
            <td>${a.adminId}</td>
            <td>${a.name}</td>
            <td>${a.email}</td>
        </tr>`;
        body.innerHTML += row;
    });
}

// Load Employee Data
if (document.getElementById("employeeTable")) {
    const body = document.querySelector("#employeeTable tbody");

    employees.forEach(e => {
        const row = `<tr>
            <td>${e.empId}</td>
            <td>${e.name}</td>
            <td>${e.dept}</td>
            <td>${e.salary}</td>
        </tr>`;
        body.innerHTML += row;
    });
}
