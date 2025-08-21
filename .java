const form = document.getElementById("assignment-form");
const list = document.getElementById("assignment-list");

form.addEventListener("submit", (e) => {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const due = new Date(document.getElementById("due").value);
    const notify = document.getElementById("notify").checked;

    if (!name || !due) return;

    const li = document.createElement("li");
    const now = new Date();
    const timeLeft = Math.floor((due - now) / (1000 * 60 * 60 * 24));

    li.textContent = `${name} - Due: ${due.toLocaleString()} (${timeLeft} days left)`;
    list.appendChild(li);

    if (notify && "Notification" in window) {
        if (Notification.permission === "granted") {
            scheduleNotification(name, due);
        } else {
            Notification.requestPermission().then((perm) => {
                if (perm === "granted") scheduleNotification(name, due);
            });
        }
    }

    form.reset();
});

function scheduleNotification(name, due) {
    const now = new Date();
    const timeUntil = due.getTime() - now.getTime();

    if (timeUntil > 0) {
        setTimeout(() => {
            new Notification("Assignment Reminder", {
                body: `${name} is due soon!`,
                icon: "📌"
            });
        }, Math.min(timeUntil, 5000)); // test with 5s, adjust later
    }
}