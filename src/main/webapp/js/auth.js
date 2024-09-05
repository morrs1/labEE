let urlForRedirect;
document.getElementById('auth-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    console.log(JSON.stringify(data));

    // Первый запрос
    fetch('/auth', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json' // Убедитесь, что заголовок установлен
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Сеть ответила с ошибкой');
            }
            // Перенаправление на другую страницу
            urlForRedirect = response.url;

            // Второй запрос, который будет выполнен только после успешного завершения первого
            return fetch('/check-auth');
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Преобразуем ответ в JSON
        })
        .then(data => {
            // Выводим alert с данными из JSON
            alert(data.logInMessage);
            if (data.logInAttempts !== undefined) {
                alert("Количество попыток входа: " + data.logInAttempts);
            }
            window.location.href = urlForRedirect;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });


});