// ===== LocalStorage Helpers =====
function getEmployees() {
    return JSON.parse(localStorage.getItem("employees")) || [];
}

function saveEmployees(list) {
    localStorage.setItem("employees", JSON.stringify(list));
}

// ===== Load Employee Table =====
function loadEmployeeTable() {
    const employees = getEmployees();
    const tbody = document.querySelector("#employeeTable tbody");
    if (!tbody) return;

    tbody.innerHTML = "";

    employees.forEach(emp => {
        const row = `
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.department}</td>
                <td>${emp.salary}</td>
                <td>${emp.email}</td>

                <td>
                    <button class="edit-btn action-btn"
                        onclick="editEmployee(${emp.id})">Edit</button>

                    <button class="delete-btn action-btn"
                        onclick="deleteEmployee(${emp.id})">Delete</button>
                </td>
            </tr>
        `;

        tbody.innerHTML += row;
    });

    document.getElementById("totalEmployees").innerText = employees.length;
}

// ===== Add Employee =====
if (document.getElementById("addEmployeeForm")) {
    document.getElementById("addEmployeeForm").addEventListener("submit", e => {
        e.preventDefault();

        const employees = getEmployees();

        const newEmployee = {
            id: Date.now(),
            name: document.getElementById("name").value,
            department: document.getElementById("department").value,
            salary: Number(document.getElementById("salary").value),
            email: document.getElementById("email").value
        };

        employees.push(newEmployee);
        saveEmployees(employees);

        alert("Employee added successfully!");
        window.location.href = "employee-dashboard.html";
    });
}

// ===== Load Update Data =====
if (document.getElementById("updateEmployeeForm")) {
    const params = new URLSearchParams(window.location.search);
    const id = Number(params.get("id"));
    const emp = getEmployees().find(e => e.id === id);

    document.getElementById("empId").value = emp.id;
    document.getElementById("name").value = emp.name;
    document.getElementById("department").value = emp.department;
    document.getElementById("salary").value = emp.salary;
    document.getElementById("email").value = emp.email;

    document.getElementById("updateEmployeeForm").addEventListener("submit", function(e) {
        e.preventDefault();

        let employees = getEmployees();
        const id = Number(document.getElementById("empId").value);

        employees = employees.map(e =>
            e.id === id
                ? {
                      id,
                      name: document.getElementById("name").value,
                      department: document.getElementById("department").value,
                      salary: Number(document.getElementById("salary").value),
                      email: document.getElementById("email").value
                  }
                : e
        );

        saveEmployees(employees);
        alert("Employee updated!");
        window.location.href = "employee-dashboard.html";
    });
}

// ===== Edit Redirect =====
function editEmployee(id) {
    window.location.href = `update-employee.html?id=${id}`;
}

// ===== Delete Employee =====
function deleteEmployee(id) {
    if (!confirm("Delete this employee?")) return;

    let employees = getEmployees();
    employees = employees.filter(e => e.id !== id);
    saveEmployees(employees);

    loadEmployeeTable();
}
