// Load sidebar and navbar dynamically into pages
window.addEventListener("DOMContentLoaded", () => {
    loadComponent("navbar-placeholder", "components/navbar.html");
    loadComponent("sidebar-placeholder", "components/sidebar.html");

    updateStats();
    loadRecentActivities();
});

// dynamic component loader
function loadComponent(holderId, filePath) {
    const holder = document.getElementById(holderId);
    if (!holder) return;

    fetch(`../../${filePath}`)
        .then(res => res.text())
        .then(html => holder.innerHTML = html)
        .then(() => initNavbar())
        .then(() => initSidebar());
}

// NAVBAR functionality
function initNavbar() {
    const darkToggle = document.getElementById("darkToggle");
    if (darkToggle) {
        darkToggle.addEventListener("click", () => {
            document.body.classList.toggle("theme-dark");
            darkToggle.textContent =
                document.body.classList.contains("theme-dark") ? "☀️" : "🌙";
        });
    }
}

// SIDEBAR functionality
function initSidebar() {
    const toggleBtn = document.getElementById("toggleSidebar");
    const sidebar = document.querySelector(".sidebar");

    if (!toggleBtn || !sidebar) return;

    toggleBtn.addEventListener("click", () => {
        sidebar.classList.toggle("sidebar-collapsed");
    });
}

// STATS
function updateStats() {
    let admins = JSON.parse(localStorage.getItem("admins")) || [];
    let employees = JSON.parse(localStorage.getItem("employees")) || [];
    let reports = JSON.parse(localStorage.getItem("reports")) || [];

    document.getElementById("statAdmins").textContent = admins.length;
    document.getElementById("statEmployees").textContent = employees.length;
    document.getElementById("statReports").textContent = reports.length;
}

// RECENT ACTIVITIES
function addActivity(text) {
    let logs = JSON.parse(localStorage.getItem("activities")) || [];
    logs.unshift({ text, time: new Date().toLocaleString() });
    localStorage.setItem("activities", JSON.stringify(logs));
}

function loadRecentActivities() {
    const box = document.getElementById("recentActivities");
    if (!box) return;

    let logs = JSON.parse(localStorage.getItem("activities")) || [];

    if (logs.length === 0) {
        box.innerHTML = `<p class="muted">No activities yet.</p>`;
        return;
    }

    box.innerHTML = logs.slice(0, 5).map(l =>
        `<p>• ${l.text} <br><span class="small">${l.time}</span></p>`
    ).join("");
}
