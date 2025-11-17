// ===== LocalStorage Helpers =====
function getAudits() {
    return JSON.parse(localStorage.getItem("audits")) || [];
}

function saveAudits(list) {
    localStorage.setItem("audits", JSON.stringify(list));
}

// ===== Load Audit Table =====
function loadAuditTable() {
    const audits = getAudits();
    const tbody = document.querySelector("#auditTable tbody");

    if (!tbody) return;

    tbody.innerHTML = "";

    audits.forEach(audit => {
        tbody.innerHTML += `
            <tr>
                <td>${audit.id}</td>
                <td>${audit.userId}</td>
                <td>${audit.action}</td>
                <td>${audit.timestamp}</td>
                <td>${audit.status}</td>
            </tr>
        `;
    });
}

// ===== Add Mock Log (for testing) =====
function addMockAudit() {
    let audits = getAudits();

    const newLog = {
        id: Date.now(),
        userId: Math.floor(Math.random() * 10) + 1,
        action: "User performed a sample action",
        timestamp: new Date().toLocaleString(),
        status: "SUCCESS"
    };

    audits.push(newLog);
    saveAudits(audits);

    alert("Mock Audit Log Added!");
    loadAuditTable();
}

// Auto-load
document.addEventListener("DOMContentLoaded", loadAuditTable);
