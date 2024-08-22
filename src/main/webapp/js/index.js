let verify = false;
let signInButton = document.getElementById("signInButton")
let signOutButton = document.getElementById("signOutButton")

function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

function checkVerify() {
    let cookieValue = getCookie("verify")
    verify = !!cookieValue;
}

function updatePage() {
    checkVerify()
    if (verify) {
        signInButton.style.display = 'none';
        signOutButton.style.display = 'block';
    } else {
        signInButton.style.display = 'block';
        signOutButton.style.display = 'none';
    }
}

window.onload = updatePage;