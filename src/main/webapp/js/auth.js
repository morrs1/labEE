let signButton = document.getElementById("signButton")


async function signButtonClicked() {
    fetch('/auth-page') // Отправляем GET-запрос
        .then(response => {
            return response.text(); // Преобразуем ответ в текст
        })
        .then(data => {
            document.getElementById("response").innerText = data; // Отображаем ответ на странице
        })
        .catch(error => {
            console.error('Произошла ошибка:', error);
        });
}

signButton.addEventListener('click', signButtonClicked, false)