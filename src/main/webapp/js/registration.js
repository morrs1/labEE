let urlForRedirect;
document.getElementById("registration-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    console.log(JSON.stringify(data));

    fetch('/registration', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error('Сеть ответила с ошибкой');
        }

        urlForRedirect = response.url;

        return fetch("/check-registration")
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Преобразуем ответ в JSON
        })
        .then(data => {
            console.log(data)
            alert(data.RegistrationMessage)
            window.location.href = urlForRedirect;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });


})