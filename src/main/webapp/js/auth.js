let signButton = document.getElementById("signButton")


async function signButtonClicked() {
    try {
        const response = await fetch("/auth", {
            method: "GET",
        });

        if (response.ok) {
            // Если ответ успешный (статус 2xx)
            window.location.href = response.url;
        } else {
            // Если ответ неуспешный
            console.error("Произошла ошибка при отправке формы.");
        }
    } catch (error) {
        console.error("Ошибка при выполнении запроса:", error);
    }
}

signButton.addEventListener('click', signButtonClicked, false)