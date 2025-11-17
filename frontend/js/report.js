// ===== LocalStorage Helpers =====
function getReports() {
    return JSON.parse(localStorage.getItem("reports")) || [];
}

function saveReports(list) {
    localStorage.setItem("reports", JSON.stringify(list));
}

// ===== Load Table =====
function loadReportTable() {
    const reports = getReports();
    const tbody = document.querySelector("#reportTable tbody");

    if (!tbody) return;

    tbody.innerHTML = "";

    reports.forEach(r => {
        tbody.innerHTML += `
            <tr>
                <td>${r.id}</td>
                <td>${r.type}</td>
                <td>${r.generatedBy}</td>
                <td>${r.date}</td>
                <td>${r.description}</td>
            </tr>
        `;
    });

    const count = document.getElementById("totalReports");
    if (count) count.innerText = reports.length;
}

// ===== Add Report =====
if (document.getElementById("addReportForm")) {
    document.getElementById("addReportForm").addEventListener("submit", e => {
        e.preventDefault();

        const reports = getReports();

        const newReport = {
            id: Date.now(),
            type: document.getElementById("type").value,
            generatedBy: document.getElementById("generatedBy").value,
            date: document.getElementById("date").value,
            description: document.getElementById("description").value
        };

        reports.push(newReport);
        saveReports(reports);

        alert("Report added!");
        window.location.href = "report-dashboard.html";
    });
}

// Auto-load table
document.addEventListener("DOMContentLoaded", loadReportTable);
