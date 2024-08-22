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
        signInButton.setAttribute("hidden", "true");
        signOutButton.removeAttribute("hidden");
    } else {
        signInButton.removeAttribute("hidden")
        signOutButton.setAttribute("hidden", "true");
    }
}

updatePage()