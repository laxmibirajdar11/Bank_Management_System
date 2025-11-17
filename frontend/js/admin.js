// ========== LocalStorage Helper Functions ==========
function getAdmins() {
    return JSON.parse(localStorage.getItem("admins")) || [];
}

function saveAdmins(admins) {
    localStorage.setItem("admins", JSON.stringify(admins));
}

// ========== LOAD ADMIN TABLE ==========
function loadAdminTable() {
    const admins = getAdmins();
    const tbody = document.querySelector("#adminTable tbody");
    if (!tbody) return;

    tbody.innerHTML = "";

    admins.forEach(admin => {
        const row = `
            <tr>
                <td>${admin.id}</td>
                <td>${admin.name}</td>
                <td>${admin.email}</td>

                <td>
                    <button class="edit-btn action-btn"
                        onclick="editAdmin(${admin.id})">Edit</button>

                    <button class="delete-btn action-btn"
                        onclick="deleteAdmin(${admin.id})">Delete</button>
                </td>
            </tr>
        `;
        tbody.innerHTML += row;
    });

    document.getElementById("totalAdmins").innerText = admins.length;
}

// ========== ADD ADMIN ==========
if (document.getElementById("addAdminForm")) {
    document.getElementById("addAdminForm").addEventListener("submit", function(e) {
        e.preventDefault();

        const admins = getAdmins();

        const newAdmin = {
            id: Date.now(),
            name: document.getElementById("name").value,
            email: document.getElementById("email").value
        };

        admins.push(newAdmin);
        saveAdmins(admins);

        alert("Admin added successfully!");
        window.location.href = "admin-dashboard.html";
    });
}

// ========== LOAD ADMIN FOR UPDATE ==========
if (document.querySelector("#updateAdminForm")) {
    const params = new URLSearchParams(window.location.search);
    const id = Number(params.get("id"));

    const admin = getAdmins().find(a => a.id === id);

    if (admin) {
        document.getElementById("adminId").value = admin.id;
        document.getElementById("name").value = admin.name;
        document.getElementById("email").value = admin.email;
    }

    document.getElementById("updateAdminForm").addEventListener("submit", function(e) {
        e.preventDefault();

        let admins = getAdmins();
        const id = Number(document.getElementById("adminId").value);

        admins = admins.map(a =>
            a.id === id
                ? {
                    id: id,
                    name: document.getElementById("name").value,
                    email: document.getElementById("email").value
                }
                : a
        );

        saveAdmins(admins);
        alert("Admin updated successfully!");
        window.location.href = "admin-dashboard.html";
    });
}

// ========== EDIT REDIRECT ==========
function editAdmin(id) {
    window.location.href = `update-admin.html?id=${id}`;
}

// ========== DELETE ADMIN ==========
function deleteAdmin(id) {
    if (!confirm("Delete this admin?")) return;

    let admins = getAdmins();
    admins = admins.filter(a => a.id !== id);
    saveAdmins(admins);

    loadAdminTable();
}
