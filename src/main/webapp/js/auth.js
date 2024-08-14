let signButton = document.getElementById("signButton")

signButton.addEventListener("click", function () {
    console.log("fdfs");
    fetch("index.jsp", {method: "GET"}).then(function (response) {
        if (response.ok) {
            window.location.href = "/";
            console.log("aboba")
        } else {
            response.text().then(function (text) {
                console.log(text);
                console.log("ne aboba")
            });
        }
    });
});