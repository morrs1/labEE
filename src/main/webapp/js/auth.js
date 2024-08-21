document.getElementById('auth-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    console.log(JSON.stringify(data));
    fetch('/auth', {
        method: 'POST',
        body: JSON.stringify(data),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Сеть ответила с ошибкой');
            }
            window.location.href = response.url;

        })
});