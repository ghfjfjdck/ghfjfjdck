function showNotification(message) {
    const modal = document.getElementById("notificationModal");
    const notificationMessage = document.getElementById("notificationMessage");
    notificationMessage.textContent = message;
    modal.style.display = "block";
}

function closeNotification() {
    const modal = document.getElementById("notificationModal");
    modal.style.display = "none";
}
