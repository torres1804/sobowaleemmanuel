<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assignment Reminder App</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>📌 Assignment Reminder App</h1>
    <form id="assignment-form">
        <input type="text" id="name" placeholder="Assignment" required>
        <input type="datetime-local" id="due" required>
        <label>
            <input type="checkbox" id="notify">
            Enable Browser Notification
        </label>
        <button type="submit">Add Assignment</button>
    </form>
    <ul id="assignment-list"></ul>
    <script src="app.js"></script>
</body>
</html>